package com.avinay.onlineTicketReservation.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.Length;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private Long paymentId;

    @Length(min=1)
    private String description;

    @NotNull
    private BigDecimal totalFare;

    @OneToOne(mappedBy = "payment", cascade = CascadeType.MERGE)
    @JsonManagedReference
    private TicketReserved ticketReserved;

    @Length(min=1)
    private String busNumber;

    @Column(name = "username", columnDefinition = "VARCHAR(255) REFERENCES users(username)")
    private String username;

    @NotNull
    @Column(name = "is_payment_done")
    private boolean isPaymentDone;

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(BigDecimal totalFare) {
        this.totalFare = totalFare;
    }

    public TicketReserved getTicketReserved() {
        return ticketReserved;
    }

    public void setTicketReserved(TicketReserved ticketReserved) {
        this.ticketReserved = ticketReserved;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isPaymentDone() {
        return isPaymentDone;
    }

    public void setPaymentDone(boolean paymentDone) {
        isPaymentDone = paymentDone;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }
}
