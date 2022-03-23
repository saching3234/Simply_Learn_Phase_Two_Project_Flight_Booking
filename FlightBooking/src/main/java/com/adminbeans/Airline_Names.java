package com.adminbeans;

public class Airline_Names {
	private int airlineId;
	private String airlineName;

	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	@Override
	public String toString() {
		return "Airline_Names [airlineId=" + airlineId + ", airlineName=" + airlineName + "]";
	}

}
