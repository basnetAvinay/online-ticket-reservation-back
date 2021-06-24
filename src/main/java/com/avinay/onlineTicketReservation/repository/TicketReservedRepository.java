package com.avinay.onlineTicketReservation.repository;

import com.avinay.onlineTicketReservation.model.TicketReserved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TicketReservedRepository extends JpaRepository<TicketReserved, Long> {

    List<TicketReserved> findByUsername(String username);

    @Modifying
    @Transactional
    void deleteByUsername(String username);
}
