package com.avinay.onlineticketreservation.service.impl;

import com.avinay.onlineticketreservation.model.dto.request.TicketReservationCreate;
import com.avinay.onlineticketreservation.model.dto.response.TicketReservationResponse;
import com.avinay.onlineticketreservation.model.dto.response.TicketReservationSales;
import com.avinay.onlineticketreservation.model.entity.Ticket;
import com.avinay.onlineticketreservation.model.entity.TicketReservation;
import com.avinay.onlineticketreservation.model.entity.User;
import com.avinay.onlineticketreservation.repository.TicketReservationRepository;
import com.avinay.onlineticketreservation.service.CustomUserDetailsService;
import com.avinay.onlineticketreservation.service.TicketReservationService;
import com.avinay.onlineticketreservation.service.TicketService;
import com.avinay.onlineticketreservation.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class TicketReservationServiceImpl implements TicketReservationService {

    private TicketReservationRepository ticketReservationRepository;
    private TicketService ticketService;
    private CustomUserDetailsService customUserDetailsService;
    private UserService userService;

    public TicketReservationServiceImpl(TicketReservationRepository ticketReservedRepository,
                                        TicketService ticketService,
                                        CustomUserDetailsService customUserDetailsService,
                                        UserService userService) {
        this.ticketReservationRepository = ticketReservedRepository;
        this.ticketService = ticketService;
        this.customUserDetailsService = customUserDetailsService;
        this.userService = userService;
    }

    @Override
    public ResponseEntity<TicketReservationResponse> createTicketReservation(TicketReservationCreate ticketReservationCreate) {
        Ticket ticket = ticketService.findByTicketId(ticketReservationCreate.getTicketId());
        if (ticket == null) {
            System.out.println("Sorry, the ticket is not available.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (ticket.getAvailableSeats() < ticketReservationCreate.getNoOfSeatReserved()) {
            System.out.println("Sorry, the no. of seat/s reserved is more than the no. of available seat/s.");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            ticket.setAvailableSeats(ticket.getAvailableSeats() - ticketReservationCreate.getNoOfSeatReserved());
            ticketService.save(ticket);
            User user = userService.findUserByUsername(customUserDetailsService.getUsername());
            TicketReservation ticketReservation = new TicketReservation();
            ticketReservation.setNoOfSeatReserved(ticketReservationCreate.getNoOfSeatReserved());
            ticketReservation.setTicket(ticket);
            ticketReservation.setPaymentDone(false);
            ticketReservation.setUser(user);
            TicketReservation result = ticketReservationRepository.save(ticketReservation);
            return new ResponseEntity<>(new TicketReservationResponse(result), HttpStatus.CREATED);
        }
    }

    @Override
    public List<TicketReservation> findAllUnpaidTicketReservationOfCurrentUser() {
        User user = userService.findUserByUsername(customUserDetailsService.getUsername());
        return ticketReservationRepository.findAllUnpaidByUser(user);
    }

    @Override
    public void payAllUnpaidTicketReservationOfCurrentUser() {
        User user = userService.findUserByUsername(customUserDetailsService.getUsername());
        ticketReservationRepository.payAllUnpaidByUser(user);
    }

    @Override
    public List<TicketReservationSales> getPaymentSumGroupByBusNumber() {
        List<Map<String, Object>> saleGroups = ticketReservationRepository.getPaymentSumGroupByBusNumber();
        return saleGroups.stream()
                .map(item -> new TicketReservationSales((String) item.get("busNumber"), (BigDecimal) item.get("sales")))
                .collect(Collectors.toList());
    }
}
