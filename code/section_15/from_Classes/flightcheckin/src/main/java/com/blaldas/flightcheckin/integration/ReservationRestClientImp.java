package com.blaldas.flightcheckin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.blaldas.flightcheckin.integration.dto.Reservation;
import com.blaldas.flightcheckin.integration.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImp implements ReservationRestClient {

	private static final String RESERVATION_REST_URL = "http://localhost:8080/flightreservation/";

	@Override
	public Reservation findReservation(int reservationId) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(RESERVATION_REST_URL + "reservations/"+  reservationId, Reservation.class);
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(RESERVATION_REST_URL + "/updateReservation", request, Reservation.class);
	}

}
