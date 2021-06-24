package com.avinay.onlineticketreservation.repository;

import com.avinay.onlineticketreservation.model.dto.response.TicketReservationSales;
import com.avinay.onlineticketreservation.model.entity.TicketReservation;
import com.avinay.onlineticketreservation.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TicketReservationRepository extends JpaRepository<TicketReservation, Integer> {

    @Query("Select tr from TicketReservation tr where tr.user = :user and tr.isPaymentDone = false")
    List<TicketReservation> findAllUnpaidByUser(@Param("user") User user);

    @Modifying
    @Query("Update TicketReservation tr Set tr.isPaymentDone = true Where tr.user = :user And tr.isPaymentDone = false")
    void payAllUnpaidByUser(@Param("user") User user);

    @Query("Select tr.ticket.bus.busNumber as busNumber, Sum(tr.noOfSeatReserved * tr.ticket.farePerSeat) as sales From TicketReservation tr Where tr.isPaymentDone = true Group By tr.ticket.bus.busNumber")
    List<Map<String, Object>> getPaymentSumGroupByBusNumber();
}
