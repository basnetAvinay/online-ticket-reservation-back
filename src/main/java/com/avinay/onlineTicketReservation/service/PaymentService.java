package com.avinay.onlineTicketReservation.service;

import com.avinay.onlineTicketReservation.model.Payment;
import com.avinay.onlineTicketReservation.model.Sales;

import java.util.ArrayList;

public interface PaymentService {

    void save(Payment payment);

    ArrayList<Payment> findUnpaidTicketsByUsername();

    void payAllUnpaidTicketsByUsername();

    ArrayList<Payment> findAllPaidTickets();

    ArrayList<Sales> findTotalSalesByBus();
}
