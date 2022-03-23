package com.services;

import java.util.ArrayList;
import java.util.List;

import com.adminbeans.Airline_Names;
import com.adminbeans.Flight;
import com.dao.AirlinesDao;
import com.dao.FlightDao;

public class Flight_Service {

	FlightDao dao = new FlightDao();

	public boolean insertNew_Flight(Flight bean) {

		return dao.insertNewFlight(bean);

	}

	public List<Flight> getAll_Flights() {
		List<Flight> list = new ArrayList<Flight>();

		list = dao.getFlights();
		return list;

	}

	public List<Flight> getAll_S_D_MatchedFlights(String source, String destination) {
		List<Flight> list = new ArrayList<Flight>();

		list = dao.get_S_D_MatchedFlights(source, destination);
		return list;

	}

	// getting the singgle file details
	public Flight getSingleMatchedFlight(int flightId) {
		Flight list = new Flight();
		list = dao.getSingleFlight(flightId);
		return list;

	}

	public boolean delete_Flight(int flightId) {
		return dao.deleteFlight(flightId);
	}

	// returning the single record for updating
	public Flight edit_Flight(int flightId) {
		return dao.getSingleFlight(flightId);
	}

	public boolean update_Flight(Flight bean) {

		return dao.changeFlight(bean);
	}

	

}
