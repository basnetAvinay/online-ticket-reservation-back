package com.avinay.onlineTicketReservation.controller;

import com.avinay.onlineTicketReservation.model.Payment;
import com.avinay.onlineTicketReservation.model.Sales;
import com.avinay.onlineTicketReservation.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(path = "/ticket-payment", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Payment> findUnpaidTicketsByUsername() {
        return paymentService.findUnpaidTicketsByUsername();
    }

    @RequestMapping(path = "/complete-payment", method = RequestMethod.GET)
    ResponseEntity payAllUnpaidTicketsByUsername() {
        paymentService.payAllUnpaidTicketsByUsername();
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(path =  "/sales", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Sales> findTotalSalesByBus() {
        return paymentService.findTotalSalesByBus();
    }
}
