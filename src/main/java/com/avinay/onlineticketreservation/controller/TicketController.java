package com.avinay.onlineticketreservation.controller;

import com.avinay.onlineticketreservation.model.entity.Ticket;
import com.avinay.onlineticketreservation.service.TicketService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @RequestMapping(path = "/tickets", method = RequestMethod.GET)
    public List<Ticket> findAll() {
        return ticketService.findAll();
    }
}
