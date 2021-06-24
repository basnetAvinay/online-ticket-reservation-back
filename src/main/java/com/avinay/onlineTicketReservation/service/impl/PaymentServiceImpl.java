package com.avinay.onlineTicketReservation.service.impl;

import com.avinay.onlineTicketReservation.model.Payment;
import com.avinay.onlineTicketReservation.model.Sales;
import com.avinay.onlineTicketReservation.repository.PaymentRepository;
import com.avinay.onlineTicketReservation.service.CustomUserDetailsService;
import com.avinay.onlineTicketReservation.service.PaymentService;
import com.avinay.onlineTicketReservation.service.SalesService;
import com.avinay.onlineTicketReservation.service.TicketReservedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private TicketReservedService ticketReservedService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private SalesService salesService;

    @Override
    public void save(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public ArrayList<Payment> findUnpaidTicketsByUsername() {
        return paymentRepository.findUnpaidTicketsByUsername(customUserDetailsService.getUsername());
    }

    @Override
    public void payAllUnpaidTicketsByUsername() {
        System.out.println("\n----> payment in progress <----");
        ArrayList<Payment> payments = this.findUnpaidTicketsByUsername();

        for (Payment payment : payments) {
            if (salesService.existsByBusNumber(payment.getBusNumber())) {
                Sales sales = salesService.findByBusNumber(payment.getBusNumber());
                BigDecimal grandTotal = sales.getTotalSales().add(payment.getTotalFare());
                sales.setTotalSales(grandTotal);
                salesService.save(sales);
            } else {
                Sales sales = new Sales();
                sales.setBusNumber(payment.getBusNumber());
                sales.setTotalSales(payment.getTotalFare());
                salesService.save(sales);
            }
        }

        paymentRepository.payAllUnpaidTicketsByUsername(customUserDetailsService.getUsername());
        System.out.println("\n----> deleting tickets from ticket reserve <----");
        ticketReservedService.deleteByUsername();
        System.out.println("\n----> updating total sales <----");

        System.out.println("\n----> payment complete <----");
    }

    @Override
    public ArrayList<Payment> findAllPaidTickets() {
        return paymentRepository.findAllPaidTickets();
    }

    @Override
    public ArrayList<Sales> findTotalSalesByBus() {
        return null;
    }

    //    @Override
//    public ArrayList<Sales> findTotalSalesByBus() {
//        System.out.println("=========>Total Sales");
//        ArrayList<Payment> payments = paymentRepository.
//        ArrayList<Sale> sales = new ArrayList<>();
//
//        for (int i=0; i<payments.size(); i++) {
//            for (int j=i+1; j<payments.size(); j++) {
//                Payment currentPayment = payments.get(i);
//                Payment nextPayment = payments.get(j);
//                if (currentPayment.getBusNumber().equalsIgnoreCase(nextPayment.getBusNumber())) {
//                    System.out.println("\n\n\nFound Duplicate: \n" + payments.get(i).getBusNumber() + "\n\n\n");
//                    currentPayment.setTotalFare();
//                }
//            }
//        }
//
//        return null;
//    }
}
