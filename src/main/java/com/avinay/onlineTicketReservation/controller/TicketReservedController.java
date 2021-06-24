package com.avinay.onlineTicketReservation.controller;

import com.avinay.onlineTicketReservation.model.TicketReserved;
import com.avinay.onlineTicketReservation.service.TicketReservedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/ticketReserved")
public class TicketReservedController {

    @Autowired
    private TicketReservedService ticketReservedService;

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public void save(@RequestBody TicketReserved ticketReserved) {
        ticketReservedService.save(ticketReserved);
    }

    @RequestMapping(path = "/findAllTicketsByUsername", method = RequestMethod.GET)
    @ResponseBody
    public List<TicketReserved> findAllTicketsByUsername() {
        return ticketReservedService.findByUsername();
    }
}
