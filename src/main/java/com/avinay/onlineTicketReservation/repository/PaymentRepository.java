package com.avinay.onlineTicketReservation.repository;

import com.avinay.onlineTicketReservation.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("select p from Payment p where p.username = :username and p.isPaymentDone = false")
    ArrayList<Payment> findUnpaidTicketsByUsername(@Param("username") String username);

    @Transactional
    @Modifying
    @Query("update Payment p set p.isPaymentDone = true where p.username = :username and p.isPaymentDone = false")
    void payAllUnpaidTicketsByUsername(@Param("username") String username);

    @Query("select p from Payment p where p.isPaymentDone = true")
    ArrayList<Payment> findAllPaidTickets();
}
