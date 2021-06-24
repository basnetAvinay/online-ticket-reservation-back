package com.avinay.onlineticketreservation.controller;

import com.avinay.onlineticketreservation.model.dto.request.TicketReservationCreate;
import com.avinay.onlineticketreservation.model.dto.response.TicketReservationResponse;
import com.avinay.onlineticketreservation.model.dto.response.TicketReservationSales;
import com.avinay.onlineticketreservation.model.entity.TicketReservation;
import com.avinay.onlineticketreservation.service.TicketReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/ticket-reservation")
public class TicketReservationController {

    private TicketReservationService ticketReservationService;

    public TicketReservationController(TicketReservationService ticketReservedService) {
        this.ticketReservationService = ticketReservedService;
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public ResponseEntity<TicketReservationResponse> save(@RequestBody TicketReservationCreate ticketReservationCreate) {
        return ticketReservationService.createTicketReservation(ticketReservationCreate);
    }

    @RequestMapping(path = "/my", method = RequestMethod.GET)
    public ResponseEntity<List<TicketReservationResponse>> findAllTicketsByUsername() {
        List<TicketReservation> ticketReservations = ticketReservationService.findAllUnpaidTicketReservationOfCurrentUser();
        List<TicketReservationResponse> ticketReservationResponses = ticketReservations.stream()
                .map(tr -> new TicketReservationResponse(tr))
                .collect(Collectors.toList());
        return new ResponseEntity<>(ticketReservationResponses, HttpStatus.OK);
    }

    @RequestMapping(path = "/payment", method = RequestMethod.GET)
    public ResponseEntity<?> payment() {
        ticketReservationService.payAllUnpaidTicketReservationOfCurrentUser();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/sales", method = RequestMethod.GET)
    public ResponseEntity<List<TicketReservationSales>> getPaymentGroupByBusNumber() {
        return new ResponseEntity<>(ticketReservationService.getPaymentSumGroupByBusNumber(), HttpStatus.OK);
    }
}
