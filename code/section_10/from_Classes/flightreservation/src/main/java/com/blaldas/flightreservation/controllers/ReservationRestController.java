package com.blaldas.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blaldas.flightreservation.dto.ReservationUpdateRequest;
import com.blaldas.flightreservation.entities.Reservation;
import com.blaldas.flightreservation.repos.ReservationRepository;
import com.blaldas.flightreservation.util.PDFGenerator;

@RestController
@CrossOrigin
public class ReservationRestController {

	@Autowired
	ReservationRepository reservationRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);


	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") int reservationId) {
		LOGGER.info("Inside findReservation\t" + reservationId);
		
		System.out.println("request id: \t" + reservationId + "\nAnswer:");
		Reservation res = reservationRepository.findById(reservationId).get();
		System.out.println(res.toString());
		
		return res;

	}

	@RequestMapping("/updateReservation")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		LOGGER.info("Inside updateReservation\t" + request);

		
		Reservation reservation = reservationRepository.getReferenceById(request.getId());
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.isCheckedIn());
		
		LOGGER.info("Saving reservation:\t" + reservation);
		return reservationRepository.save(reservation);
	}

}
