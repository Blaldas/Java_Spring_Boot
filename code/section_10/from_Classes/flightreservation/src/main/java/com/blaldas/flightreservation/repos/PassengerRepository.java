package com.blaldas.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blaldas.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
