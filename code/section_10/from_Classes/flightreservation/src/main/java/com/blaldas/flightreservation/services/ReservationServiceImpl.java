package com.blaldas.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blaldas.flightreservation.dto.ReservationRequest;
import com.blaldas.flightreservation.entities.Flight;
import com.blaldas.flightreservation.entities.Passenger;
import com.blaldas.flightreservation.entities.Reservation;
import com.blaldas.flightreservation.repos.FlightRepository;
import com.blaldas.flightreservation.repos.PassengerRepository;
import com.blaldas.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;
	@Autowired
	PassengerRepository passengerRepository;
	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		int flightId = request.getFlightId();

		Flight flight = flightRepository.getReferenceById(flightId);

		Passenger passenger = new Passenger();

		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());

		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setPassenger(savedPassenger);
		reservation.setFlight(flight);
		reservation.setCheckedIn(false);

		Reservation savedReservation = reservationRepository.save(reservation);

		return savedReservation;
	}

}
