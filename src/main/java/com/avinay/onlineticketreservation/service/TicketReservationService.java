package com.avinay.onlineticketreservation.service;

import com.avinay.onlineticketreservation.model.dto.request.TicketReservationCreate;
import com.avinay.onlineticketreservation.model.dto.response.TicketReservationResponse;
import com.avinay.onlineticketreservation.model.dto.response.TicketReservationSales;
import com.avinay.onlineticketreservation.model.entity.TicketReservation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TicketReservationService {

    ResponseEntity<TicketReservationResponse> createTicketReservation(TicketReservationCreate ticketReservationCreate);

    List<TicketReservation> findAllUnpaidTicketReservationOfCurrentUser();

    void payAllUnpaidTicketReservationOfCurrentUser();

    List<TicketReservationSales> getPaymentSumGroupByBusNumber();
}
