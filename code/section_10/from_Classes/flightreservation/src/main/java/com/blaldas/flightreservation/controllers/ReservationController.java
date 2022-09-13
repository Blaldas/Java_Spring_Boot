package com.blaldas.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blaldas.flightreservation.entities.Flight;
import com.blaldas.flightreservation.repos.FlightRepository;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository;

	@RequestMapping("/showCompleteReservation")
	public String ShowCompleteReservation(@RequestParam("flightId") int flightId, ModelMap map) {
		
		Flight flight = flightRepository.getReferenceById(flightId);
		map.addAttribute("flight", flight);
		
		
		return "completeReservation";
	}
}
