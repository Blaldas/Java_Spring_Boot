package com.blaldas.flightreservation.controllers;

import java.net.Authenticator.RequestorType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blaldas.flightreservation.dto.ReservationRequest;
import com.blaldas.flightreservation.entities.Flight;
import com.blaldas.flightreservation.entities.Reservation;
import com.blaldas.flightreservation.repos.FlightRepository;
import com.blaldas.flightreservation.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	ReservationService reservationService;

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

	@RequestMapping("/showCompleteReservation")
	public String ShowCompleteReservation(@RequestParam("flightId") int flightId, ModelMap map) {
		LOGGER.info("Inside ShowCompleteReservation " + flightId);

		
		Flight flight = flightRepository.getReferenceById(flightId);
		map.addAttribute("flight", flight);

		return "completeReservation";
	}

	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap map) {
		
		LOGGER.info("Inside completeReservation " + request);

		
		Reservation reservation = reservationService.bookFlight(request);

		map.addAttribute("msg", "Reservation created sucessfully. ID:\t" + reservation.getId());

		return "reservationConfirmation";
	}

}
