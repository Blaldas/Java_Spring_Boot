package com.blaldas.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blaldas.flightreservation.dto.ReservationUpdateRequest;
import com.blaldas.flightreservation.entities.Reservation;
import com.blaldas.flightreservation.repos.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {

	@Autowired
	ReservationRepository reservationRepository;

	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") int reservationId) {
		return reservationRepository.findById(reservationId).get();

	}
	
	@RequestMapping("/updateReservation")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation = reservationRepository.getReferenceById(request.getId());
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.isCheckedIn());
		
		return reservationRepository.save(reservation);
	}

}
