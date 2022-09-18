package com.blaldas.flightcheckin.integration;

import com.blaldas.flightcheckin.integration.dto.Reservation;
import com.blaldas.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

	public Reservation findReservation(int reservationId);
	
	public Reservation updateReservation(ReservationUpdateRequest request);
}
