package com.avinay.onlineticketreservation.model.dto.request;

public class TicketReservationCreate {

    private int noOfSeatReserved;

    private int ticketId;

    public int getNoOfSeatReserved() {
        return noOfSeatReserved;
    }

    public void setNoOfSeatReserved(int noOfSeatReserved) {
        this.noOfSeatReserved = noOfSeatReserved;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
}
