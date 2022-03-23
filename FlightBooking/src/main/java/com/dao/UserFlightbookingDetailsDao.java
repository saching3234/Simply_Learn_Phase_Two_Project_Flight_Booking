package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.adminbeans.Flight;
import com.adminbeans.UserflightbookingDetails;
import com.util.DbConnection;

public class UserFlightbookingDetailsDao {

	// getting all bookedflight details for current user
	public List<UserflightbookingDetails> getAllBookedFlights(String userName) {
		List<UserflightbookingDetails> beans = new ArrayList<UserflightbookingDetails>();
		ResultSet rs = null;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "select * from userflightbooking where userName=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			rs = pst.executeQuery();

			// setting the result set into the bean
			while (rs.next()) {
				UserflightbookingDetails bean = new UserflightbookingDetails();
				bean.setBookingId(rs.getInt(1));
				bean.setFlightId(rs.getInt(2));
				bean.setFlightSource(rs.getString(3));
				bean.setFlightDestinatio(rs.getString(4));
				bean.setAirLineName(rs.getString(5));
				bean.setTicketPrice(rs.getInt(6));
				bean.setPassangerCount(rs.getInt(7));
				bean.setFinalPrice(rs.getInt(8));
				bean.setPaymentStatus(rs.getString(9));
				bean.setUserName(rs.getString(10));
				bean.setDateofjourney(rs.getString(11));
				// adding the record to the list
				beans.add(bean);
			}

		} catch (Exception e) {
			System.out.println("Error While fetching the booked Flight Details  details" + e.toString());
		}
		return beans;
	}

	/*
	 * 
	 * //getting the single record from db public Flight getSingleFlight(int
	 * flightid) { Flight bean=new Flight(); ResultSet rs=null; try { Connection
	 * con=DbConnection.mysqlConnectio(); String
	 * sql="select * from flightlist where Flight_Id=?"; PreparedStatement pst =
	 * con.prepareStatement(sql); pst.setInt(1,flightid); rs=pst.executeQuery();
	 * 
	 * //setting the result set into the bean if(rs.next()) {
	 * 
	 * bean.setFlight_Id(rs.getInt(1));; bean.setFSource(rs.getString(2));
	 * bean.setFDestinatiom(rs.getString(3)); bean.setAirlineName(rs.getString(4));
	 * bean.setTicket_Price(rs.getInt(5));
	 * 
	 * } else { bean=null; }
	 * 
	 * }catch(Exception e) {
	 * System.out.println("Error While fetching the Flight  details"+e.toString());
	 * } //retruning the admin bean return bean; }
	 * 
	 */

	// changing the specified record
	public boolean changePaymentStatus(int bookingId, String PaymentStatus) {
		boolean status = false;
		try {
			Connection con = DbConnection.mysqlConnectio();

			String sql = "UPDATE userflightbooking SET PaymentStatus = ? WHERE bookingId = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, PaymentStatus);
			pst.setInt(2, bookingId);

			int n = pst.executeUpdate();

			if (n > 0)
				status = true;

		} catch (Exception e) {
			System.out.println("Error While updating  the flight booking details" + e.toString());
		}

		return status;
	}

	// inserting the new record in the db
	public boolean insertNewFlight(UserflightbookingDetails bean) {
		boolean status = false;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "INSERT INTO userflightbooking (FlightId, FlightSource, FlightDestinatio, AirLineName, TicketPrice, PassangerCount, FinalPrice, PaymentStatus,userName, dateofjourney) VALUES (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1, bean.getFlightId());
			pst.setString(2, bean.getFlightSource());
			pst.setString(3, bean.getFlightDestinatio());
			pst.setString(4, bean.getAirLineName());
			pst.setInt(5, bean.getTicketPrice());
			pst.setInt(6, bean.getPassangerCount());
			pst.setInt(7, bean.getFinalPrice());
			pst.setString(8, bean.getPaymentStatus());
			pst.setString(9, bean.getUserName());
			pst.setString(10, bean.getDateofjourney());

			int n = pst.executeUpdate();

			if (n > 0)
				status = true;

		} catch (Exception e) {
			System.out.println("Error While entering new record in userflightbooking " + e.toString());
		}

		return status;
	}

	

}
