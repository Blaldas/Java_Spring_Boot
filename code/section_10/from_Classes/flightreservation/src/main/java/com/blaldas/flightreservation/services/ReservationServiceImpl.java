package com.blaldas.flightreservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.blaldas.flightreservation.controllers.ReservationController;
import com.blaldas.flightreservation.dto.ReservationRequest;
import com.blaldas.flightreservation.entities.Flight;
import com.blaldas.flightreservation.entities.Passenger;
import com.blaldas.flightreservation.entities.Reservation;
import com.blaldas.flightreservation.repos.FlightRepository;
import com.blaldas.flightreservation.repos.PassengerRepository;
import com.blaldas.flightreservation.repos.ReservationRepository;
import com.blaldas.flightreservation.util.EmailUtil;
import com.blaldas.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;
	@Autowired
	PassengerRepository passengerRepository;
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	PDFGenerator pdfGenerator;
	@Autowired
	EmailUtil emailUtil;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Value("${com.blaldas.flightreservation.itenerary.dirpath}")
	private String localPDFRepoPath;


	@Override
	public Reservation bookFlight(ReservationRequest request) {
		LOGGER.info("inside bookFlight ");

		int flightId = request.getFlightId();
		
		LOGGER.info("Fetching flight for ID:\t" + flightId);
		Flight flight = flightRepository.getReferenceById(flightId);

		
		Passenger passenger = new Passenger();

		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		
		LOGGER.info("Saving passenger:\t" + passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setPassenger(savedPassenger);
		reservation.setFlight(flight);
		reservation.setCheckedIn(false);
		
		LOGGER.info("Saving reservation:\t" + reservation);
		Reservation savedReservation = reservationRepository.save(reservation);
		
		String pdfPath = localPDFRepoPath+ "itenerarieN" + savedReservation.getId() + ".pdf"; /* Actual path n machine */

		LOGGER.info("Generating PDF file");
		pdfGenerator.generateItenerary(savedReservation,
				pdfPath/* Actual path n machine */);
		
		LOGGER.info("Sending email to\t" + reservation.getPassenger().getEmail());
		emailUtil.sendItenerary(reservation.getPassenger().getEmail(),pdfPath);

		return savedReservation;
	}

}
