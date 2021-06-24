package com.avinay.onlineticketreservation.model.dto.response;

import com.avinay.onlineticketreservation.model.entity.Ticket;
import com.avinay.onlineticketreservation.model.entity.TicketReservation;

public class TicketReservationResponse extends TicketReservation {

    private Integer ticketReservationId;
    private Integer noOfSeatReserved;
    private boolean isPaymentDone;
    private Ticket ticket;
    private UserResponse user;

    public TicketReservationResponse(TicketReservation ticketReservation) {
        this.ticketReservationId = ticketReservation.getTicketReservationId();
        this.noOfSeatReserved = ticketReservation.getNoOfSeatReserved();
        this.isPaymentDone = ticketReservation.isPaymentDone();
        this.ticket = ticketReservation.getTicket();
        this.user = new UserResponse(ticketReservation.getUser());
    }

    public TicketReservationResponse(Integer ticketReservationId,
                                     Integer noOfSeatReserved,
                                     boolean isPaymentDone,
                                     Ticket ticket,
                                     UserResponse user) {
        this.ticketReservationId = ticketReservationId;
        this.noOfSeatReserved = noOfSeatReserved;
        this.isPaymentDone = isPaymentDone;
        this.ticket = ticket;
        this.user = user;
    }

    public Integer getTicketReservationId() {
        return ticketReservationId;
    }

    public void setTicketReservationId(Integer ticketReservationId) {
        this.ticketReservationId = ticketReservationId;
    }

    public Integer getNoOfSeatReserved() {
        return noOfSeatReserved;
    }

    public void setNoOfSeatReserved(Integer noOfSeatReserved) {
        this.noOfSeatReserved = noOfSeatReserved;
    }

    public boolean isPaymentDone() {
        return isPaymentDone;
    }

    public void setPaymentDone(boolean paymentDone) {
        isPaymentDone = paymentDone;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
}
