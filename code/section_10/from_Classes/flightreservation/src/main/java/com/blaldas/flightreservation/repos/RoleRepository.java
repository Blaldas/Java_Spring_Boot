package com.blaldas.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blaldas.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
