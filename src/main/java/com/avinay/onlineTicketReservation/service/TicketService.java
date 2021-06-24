package com.avinay.onlineTicketReservation.service;

import com.avinay.onlineTicketReservation.model.Ticket;

import java.util.List;

public interface TicketService {

    void save(Ticket ticket);

    Ticket findByBusNumber(String busNumber);

    List<Ticket> findAll();

    void deleteByBusNumber(String busNumber);
}
