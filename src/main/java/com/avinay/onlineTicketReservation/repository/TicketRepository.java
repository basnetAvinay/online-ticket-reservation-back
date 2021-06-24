package com.avinay.onlineTicketReservation.repository;

import com.avinay.onlineTicketReservation.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {

    Ticket findByBusNumber(String busNumber);

    void deleteByBusNumber(String busNumber);
}
