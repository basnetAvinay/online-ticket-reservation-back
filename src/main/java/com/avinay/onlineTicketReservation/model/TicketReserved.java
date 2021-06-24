package com.avinay.onlineTicketReservation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket_reserved")
public class TicketReserved {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reservation_id")
    private Long reservationId;

    @Column(name = "number_of_tickets_reserved")
    private Integer numberOfTicketsReserved;

    @Column(name = "bus_number", columnDefinition = "VARCHAR(255) REFERENCES tickets(bus_number)")
    private String busNumber;

    @Column(name = "username", columnDefinition = "VARCHAR(255) REFERENCES users(username)")
    private String username;

    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "payment_id")
    @JsonBackReference
    private Payment payment;

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Integer getNumberOfTicketsReserved() {
        return numberOfTicketsReserved;
    }

    public void setNumberOfTicketsReserved(Integer numberOfTicketsReserved) {
        this.numberOfTicketsReserved = numberOfTicketsReserved;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }
}
