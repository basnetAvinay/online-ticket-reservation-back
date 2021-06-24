package com.avinay.onlineTicketReservation.service;

import com.avinay.onlineTicketReservation.model.Sales;

import java.util.ArrayList;

public interface SalesService {

    ArrayList<Sales> findAll();

    void save(Sales sales);

    boolean existsByBusNumber(String busNumber);

    Sales findByBusNumber(String busNumber);
}
