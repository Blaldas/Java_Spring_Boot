package com.blaldas.flightreservation.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blaldas.flightreservation.entities.Flight;
import com.blaldas.flightreservation.repos.FlightRepository;

@Controller
public class FlighController {

	@Autowired
	FlightRepository flightRepository;

	@RequestMapping(value = "/findFlights", method = RequestMethod.POST)
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("dateOfDeparture") @DateTimeFormat(pattern = "MM-dd-yyyy") Date dateOfDeparture,
			ModelMap map) {		
		
		List<Flight> flights = flightRepository.findFlights(from, to, dateOfDeparture);
		map.addAttribute("flights", flights);

		return "displayFlights";
	}
	
}