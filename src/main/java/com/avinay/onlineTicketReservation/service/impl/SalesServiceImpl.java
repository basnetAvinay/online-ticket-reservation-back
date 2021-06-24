package com.avinay.onlineTicketReservation.service.impl;

import com.avinay.onlineTicketReservation.model.Sales;
import com.avinay.onlineTicketReservation.repository.SalesRepository;
import com.avinay.onlineTicketReservation.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Override
    public ArrayList<Sales> findAll() {
        return (ArrayList<Sales>) salesRepository.findAll();
    }

    @Override
    public void save(Sales sales) {
        salesRepository.save(sales);
    }

    @Override
    public boolean existsByBusNumber(String busNumber) {
        return salesRepository.existsByBusNumber(busNumber);
    }

    @Override
    public Sales findByBusNumber(String busNumber) {
        return salesRepository.findByBusNumber(busNumber);
    }
}
