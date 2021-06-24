package com.avinay.onlineTicketReservation.service;

import com.avinay.onlineTicketReservation.model.TicketReserved;

import java.util.List;

public interface TicketReservedService {

    void save(TicketReserved ticketReserved);

    void delete(Long ticketId);

    List<TicketReserved> findByUsername();

    void deleteByUsername();
}
