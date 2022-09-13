package com.blaldas.flightreservation.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blaldas.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and departureDate=:departureDate")
	List<Flight> findFlights(@Param("departureCity") String from,@Param("arrivalCity") String to,@Param("departureDate") Date departureDate);

}
