package com.avinay.onlineticketreservation.service;

import com.avinay.onlineticketreservation.model.entity.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> findAll();

    Ticket findByTicketId(Integer ticketId);

    Ticket save(Ticket ticket);
}
