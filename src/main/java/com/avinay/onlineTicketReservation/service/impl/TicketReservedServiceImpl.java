package com.avinay.onlineTicketReservation.service.impl;

import com.avinay.onlineTicketReservation.model.Ticket;
import com.avinay.onlineTicketReservation.model.TicketReserved;
import com.avinay.onlineTicketReservation.repository.TicketReservedRepository;
import com.avinay.onlineTicketReservation.service.CustomUserDetailsService;
import com.avinay.onlineTicketReservation.service.TicketReservedService;
import com.avinay.onlineTicketReservation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TicketReservedServiceImpl implements TicketReservedService {

    @Autowired
    private TicketReservedRepository ticketReservedRepository;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    public void save(TicketReserved ticketReserved) {
        Ticket ticket = ticketService.findByBusNumber(ticketReserved.getBusNumber());
        int numberOfTicketsReserved = ticketReserved.getNumberOfTicketsReserved();

        if (ticket.getAvailableSeats() < numberOfTicketsReserved) {
            System.out.println("Sorry, the seat(s) reserved is more than the available seats.");
        } else {
            // update available seats in ticket
            ticket.setAvailableSeats(ticket.getAvailableSeats() - ticketReserved.getNumberOfTicketsReserved());
            ticketService.save(ticket);

            ticketReservedRepository.save(ticketReserved);
        }
    }

    @Override
    public List<TicketReserved> findByUsername() {
        return ticketReservedRepository.findByUsername(customUserDetailsService.getUsername());
    }

    @Override
    public void deleteByUsername() {
        ticketReservedRepository.deleteByUsername(customUserDetailsService.getUsername());
    }

    @Override
    public void delete(Long ticketId) {

    }
}
