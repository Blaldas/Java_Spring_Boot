package com.blaldas.flightcheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blaldas.flightcheckin.integration.ReservationRestClient;
import com.blaldas.flightcheckin.integration.dto.Reservation;
import com.blaldas.flightcheckin.integration.dto.ReservationUpdateRequest;

@Controller
public class CheckinController {

	@Autowired
	ReservationRestClient reservationRestClient;

	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		return "startCheckin";
	}

	@RequestMapping("/startCheckin")
	public String startCheckin(@RequestParam("reservationId") int id, ModelMap map) {
		Reservation reservation = reservationRestClient.findReservation(id);
		map.addAttribute("reservation", reservation);

		return "displayReservationDetails";
	}

	@RequestMapping("/completeCheckin")
	public String completeCheckin(@RequestParam("reservationId") int reservationId,
			@RequestParam("numberOfBags") int numberOfBags) {

		ReservationUpdateRequest request = new ReservationUpdateRequest();
		request.setCheckedIn(true);
		request.setId(reservationId);
		request.setNumberOfBags(numberOfBags);

		reservationRestClient.updateReservation(request);

		return "checkInConfirmation";
	}

}
