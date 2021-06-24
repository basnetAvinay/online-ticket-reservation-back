package com.avinay.onlineTicketReservation.controller;

import com.avinay.onlineTicketReservation.model.Ticket;
import com.avinay.onlineTicketReservation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public void saveTicket(@RequestBody Ticket ticket) {
        ticketService.save(ticket);
    }

    @RequestMapping(path = "/tickets", method = RequestMethod.GET)
    @ResponseBody
    public List<Ticket> findAll() {
        return ticketService.findAll();
    }

}
