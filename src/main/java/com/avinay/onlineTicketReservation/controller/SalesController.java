package com.avinay.onlineTicketReservation.controller;

import com.avinay.onlineTicketReservation.model.Sales;
import com.avinay.onlineTicketReservation.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/api/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @RequestMapping(path = "/total-sales", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Sales> findUnpaidTicketsByUsername() {
        return salesService.findAll();
    }
}
