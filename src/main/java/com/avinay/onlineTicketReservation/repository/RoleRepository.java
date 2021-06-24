package com.avinay.onlineTicketReservation.repository;

import com.avinay.onlineTicketReservation.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);
}
