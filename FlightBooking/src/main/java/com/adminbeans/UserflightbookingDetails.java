package com.adminbeans;

public class UserflightbookingDetails {
	private int bookingId;
	private int FlightId;
	private String FlightSource;
	private String FlightDestinatio;
	private String AirLineName;
	private int TicketPrice;
	private int PassangerCount;
	private int FinalPrice;
	private String PaymentStatus;
	private String userName;
	private String dateofjourney;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getFlightId() {
		return FlightId;
	}

	public void setFlightId(int flightId) {
		FlightId = flightId;
	}

	public String getFlightSource() {
		return FlightSource;
	}

	public void setFlightSource(String flightSource) {
		FlightSource = flightSource;
	}

	public String getFlightDestinatio() {
		return FlightDestinatio;
	}

	public void setFlightDestinatio(String flightDestinatio) {
		FlightDestinatio = flightDestinatio;
	}

	public String getAirLineName() {
		return AirLineName;
	}

	public void setAirLineName(String airLineName) {
		AirLineName = airLineName;
	}

	public int getTicketPrice() {
		return TicketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		TicketPrice = ticketPrice;
	}

	public int getPassangerCount() {
		return PassangerCount;
	}

	public void setPassangerCount(int passangerCount) {
		PassangerCount = passangerCount;
	}

	public int getFinalPrice() {
		return FinalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		FinalPrice = finalPrice;
	}

	public String getPaymentStatus() {
		return PaymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		PaymentStatus = paymentStatus;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDateofjourney() {
		return dateofjourney;
	}

	public void setDateofjourney(String dateofjourney) {
		this.dateofjourney = dateofjourney;
	}

	@Override
	public String toString() {
		return "UserflightbookingDetails [bookingId=" + bookingId + ", FlightId=" + FlightId + ", FlightSource="
				+ FlightSource + ", FlightDestinatio=" + FlightDestinatio + ", AirLineName=" + AirLineName
				+ ", TicketPrice=" + TicketPrice + ", PassangerCount=" + PassangerCount + ", FinalPrice=" + FinalPrice
				+ ", PaymentStatus=" + PaymentStatus + ", userName=" + userName + ", dateofjourney=" + dateofjourney
				+ "]";
	}

}
