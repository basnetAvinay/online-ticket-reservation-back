package com.avinay.onlineticketreservation.service.impl;

import com.avinay.onlineticketreservation.model.entity.Ticket;
import com.avinay.onlineticketreservation.repository.TicketRepository;
import com.avinay.onlineticketreservation.service.TicketService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket findByTicketId(Integer ticketId) {
        return ticketRepository.findById(ticketId).orElseGet(() -> null);
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
