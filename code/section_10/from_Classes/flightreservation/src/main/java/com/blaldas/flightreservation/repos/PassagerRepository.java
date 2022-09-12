package com.blaldas.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blaldas.flightreservation.entities.Passager;

public interface PassagerRepository extends JpaRepository<Passager, Integer> {

}
