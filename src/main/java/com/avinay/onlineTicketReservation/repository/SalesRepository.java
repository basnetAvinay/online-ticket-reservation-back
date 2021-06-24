package com.avinay.onlineTicketReservation.repository;

import com.avinay.onlineTicketReservation.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, String> {

    boolean existsByBusNumber(String busNumber);

    Sales findByBusNumber(String busNumber);
}
