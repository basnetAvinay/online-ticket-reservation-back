package com.avinay.onlineTicketReservation.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @Column(name = "bus_number", unique = true)
    private String busNumber;

    @Length(min = 1)
    private String busName;

    @Length(min = 1)
    private String facilities;

    @NotNull
    @Column(name = "fare_per_ticket")
    private BigDecimal farePerTicket;

    @NotNull
    private Integer totalSeats;

    @NotNull
    private Integer availableSeats;

    @Length(min=1)
    private String source;

    @Length(min=1)
    private String destination;

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public BigDecimal getFarePerTicket() {
        return farePerTicket;
    }

    public void setFarePerTicket(BigDecimal farePerTicket) {
        this.farePerTicket = farePerTicket;
    }
}
