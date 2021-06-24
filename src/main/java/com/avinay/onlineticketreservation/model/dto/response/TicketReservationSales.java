package com.avinay.onlineticketreservation.model.dto.response;

import java.math.BigDecimal;

public class TicketReservationSales {

    private String busNumber;
    private BigDecimal sales;

    public TicketReservationSales() {
    }

    public TicketReservationSales(String busNumber, BigDecimal sales) {
        this.busNumber = busNumber;
        this.sales = sales;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }
}
