package com.blaldas.flightreservation.services;

import com.blaldas.flightreservation.dto.ReservationRequest;
import com.blaldas.flightreservation.entities.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}
