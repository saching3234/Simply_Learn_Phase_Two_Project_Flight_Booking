package com.adminbeans;

public class Flight {
	private int Flight_Id;
	private String FSource;
	private String FDestinatiom;
	private String AirlineName;
	private int Ticket_Price;

	@Override
	public String toString() {
		return "Flight [Flight_Id=" + Flight_Id + ", FSource=" + FSource + ", FDestinatiom=" + FDestinatiom
				+ ", AirlineName=" + AirlineName + ", Ticket_Price=" + Ticket_Price + "]";
	}

//getter and setters

	public int getFlight_Id() {
		return Flight_Id;
	}

	public void setFlight_Id(int flight_Id) {
		Flight_Id = flight_Id;
	}

	public String getFSource() {
		return FSource;
	}

	public void setFSource(String fSource) {
		FSource = fSource;
	}

	public String getFDestinatiom() {
		return FDestinatiom;
	}

	public void setFDestinatiom(String fDestinatiom) {
		FDestinatiom = fDestinatiom;
	}

	public String getAirlineName() {
		return AirlineName;
	}

	public void setAirlineName(String airlineName) {
		AirlineName = airlineName;
	}

	public int getTicket_Price() {
		return Ticket_Price;
	}

	public void setTicket_Price(int ticket_Price) {
		Ticket_Price = ticket_Price;
	}

}
