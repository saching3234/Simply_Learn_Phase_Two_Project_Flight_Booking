package com.services;

import java.util.ArrayList;
import java.util.List;

import com.adminbeans.Airline_Names;
import com.dao.AirlinesDao;

public class Airline_Services {

	AirlinesDao dao = new AirlinesDao();

	public boolean insertNew_Airline(Airline_Names bean) {

		return dao.insertNewAirline(bean);

	}

	public List<Airline_Names> getAll_Airlines() {
		List<Airline_Names> list = new ArrayList<Airline_Names>();

		list = dao.getAirlines();
		return list;

	}

	public boolean delete_Airline(int airId) {
		return dao.deleteAirline(airId);
	}

	public Airline_Names edit_Airline(int airId) {
		return dao.getSingleAirline(airId);
	}

	public boolean update_Airline(Airline_Names bean) {

		return dao.changeAirline(bean);
	}

	/*
	 * Main Method to test the class
	 * 
	 * public static void main(String[] args) { System.out.println(new
	 * Source_To_Destination_Services().edits_d(9)); }
	 * 
	 */

}
