package com.avinay.onlineticketreservation.repository;

import com.avinay.onlineticketreservation.model.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {
}
