package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.adminbeans.Airline_Names;
import com.adminbeans.Flight;
import com.util.DbConnection;

public class FlightDao {

	// get all records from the db
	public List<Flight> get_S_D_MatchedFlights(String source, String destination) {

		List<Flight> beans = new ArrayList<Flight>();
		ResultSet rs = null;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "select * from flightlist where FSource=? and FDestinatiom=?";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, source);
			pst.setString(2, destination);
			rs = pst.executeQuery();

			// setting the result set into the bean
			while (rs.next()) {
				Flight bean = new Flight();
				bean.setFlight_Id(rs.getInt(1));
				;
				bean.setFSource(rs.getString(2));
				bean.setFDestinatiom(rs.getString(3));
				bean.setAirlineName(rs.getString(4));
				bean.setTicket_Price(rs.getInt(5));
				// adding the record to the list
				beans.add(bean);
			}

		} catch (Exception e) {
			System.out.println("Error While fetching the Flight Details  details" + e.toString());
		}
		return beans;

	}

	// getting all flight details
	public List<Flight> getFlights() {
		List<Flight> beans = new ArrayList<Flight>();
		ResultSet rs = null;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "select * from flightlist";
			PreparedStatement pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			// setting the result set into the bean
			while (rs.next()) {
				Flight bean = new Flight();
				bean.setFlight_Id(rs.getInt(1));
				;
				bean.setFSource(rs.getString(2));
				bean.setFDestinatiom(rs.getString(3));
				bean.setAirlineName(rs.getString(4));
				bean.setTicket_Price(rs.getInt(5));
				// adding the record to the list
				beans.add(bean);
			}

		} catch (Exception e) {
			System.out.println("Error While fetching the Flight Details  details" + e.toString());
		}
		return beans;
	}

	// getting the single record from db
	public Flight getSingleFlight(int flightid) {
		Flight bean = new Flight();
		ResultSet rs = null;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "select * from flightlist where Flight_Id=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, flightid);
			rs = pst.executeQuery();

			// setting the result set into the bean
			if (rs.next()) {

				bean.setFlight_Id(rs.getInt(1));
				;
				bean.setFSource(rs.getString(2));
				bean.setFDestinatiom(rs.getString(3));
				bean.setAirlineName(rs.getString(4));
				bean.setTicket_Price(rs.getInt(5));

			} else {
				bean = null;
			}

		} catch (Exception e) {
			System.out.println("Error While fetching the Flight  details" + e.toString());
		}
		// retruning the admin bean
		return bean;
	}

	// changing the specified record
	public boolean changeFlight(Flight bean) {
		boolean status = false;
		try {
			Connection con = DbConnection.mysqlConnectio();

			String sql = "update flightlist SET FSource=? , FDestinatiom=? , AirlineName=?, Ticket_Price=? WHERE Flight_Id=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, bean.getFSource());
			pst.setString(2, bean.getFDestinatiom());
			pst.setString(3, bean.getAirlineName());
			pst.setInt(4, bean.getTicket_Price());
			pst.setInt(5, bean.getFlight_Id());
			System.out.println(pst);
			int n = pst.executeUpdate();

			if (n > 0)
				status = true;

		} catch (Exception e) {
			System.out.println("Error While updating  the flight details" + e.toString());
		}

		return status;
	}

	// deleting the specified record
	public boolean deleteFlight(int flightId) {
		boolean status = false;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "delete from flightlist where Flight_Id=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, flightId);
			int n = pst.executeUpdate();

			if (n > 0)
				status = true;

		} catch (Exception e) {
			System.out.println("Error While deleting  flight record" + e.toString());
		}

		return status;
	}

	// inserting the new record in the db
	public boolean insertNewFlight(Flight bean) {
		boolean status = false;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "INSERT INTO flightlist (FSource, FDestinatiom, AirlineName, Ticket_Price) VALUES (?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, bean.getFSource());
			pst.setString(2, bean.getFDestinatiom());
			pst.setString(3, bean.getAirlineName());
			pst.setInt(4, bean.getTicket_Price());

			int n = pst.executeUpdate();

			if (n > 0)
				status = true;

		} catch (Exception e) {
			System.out.println("Error While entering new record in flightlist " + e.toString());
		}

		return status;
	}

}
