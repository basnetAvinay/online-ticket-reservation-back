package com.avinay.onlineticketreservation.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ticket_reservation")
public class TicketReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_reservation_id")
    private Integer ticketReservationId;

    @NotNull
    @Column(name = "no_of_seat_reserved", nullable = false)
    private Integer noOfSeatReserved;

    @Column(name = "is_payment_done", nullable = false)
    private boolean isPaymentDone;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
