package com.blaldas.flightcheckin.integration.dto;


public class Reservation{

	private int id;
	private boolean checkedIn;
	private int numberOfBags;
	private Passenger passenger;
	private Flight flight;



	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public int getNumberOfBags() {
		return numberOfBags;
	}

	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passager) {
		this.passenger = passager;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
