package com.avinay.onlineTicketReservation.service.impl;

import com.avinay.onlineTicketReservation.model.Ticket;
import com.avinay.onlineTicketReservation.repository.TicketRepository;
import com.avinay.onlineTicketReservation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void save(Ticket ticket){
        ticketRepository.save(ticket);
    }

    @Override
    public Ticket findByBusNumber(String busNumber) {
        return ticketRepository.findByBusNumber(busNumber);
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public void deleteByBusNumber(String busNumber) {
        ticketRepository.deleteByBusNumber(busNumber);
    }
}
