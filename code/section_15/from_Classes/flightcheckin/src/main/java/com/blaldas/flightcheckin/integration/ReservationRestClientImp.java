package com.blaldas.flightcheckin.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.blaldas.flightcheckin.integration.dto.Reservation;
import com.blaldas.flightcheckin.integration.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImp implements ReservationRestClient {

	@Value("${com.blaldas.flightcheckin.reservarion.rest.url}")
	private String RESERVATION_REST_URL;

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
