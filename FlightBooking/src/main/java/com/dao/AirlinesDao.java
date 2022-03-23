package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.adminbeans.Airline_Names;
import com.util.DbConnection;

public class AirlinesDao {

	// get all records from the db
	public List<Airline_Names> getAirlines() {
		List<Airline_Names> beans = new ArrayList<Airline_Names>();
		ResultSet rs = null;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "select * from airline_names";
			PreparedStatement pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			// setting the result set into the bean
			while (rs.next()) {
				Airline_Names bean = new Airline_Names();
				bean.setAirlineId(rs.getInt(1));
				bean.setAirlineName(rs.getString(2));
				beans.add(bean);
			}

		} catch (Exception e) {
			System.out.println("Error While fetching the Arilines  details" + e.toString());
		}
		return beans;
	}

	// getting the single record from db
	public Airline_Names getSingleAirline(int airid) {
		Airline_Names bean = new Airline_Names();
		ResultSet rs = null;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "select * from airline_names where airlineid=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, airid);
			rs = pst.executeQuery();

			// setting the result set into the bean
			if (rs.next()) {
				bean.setAirlineId(rs.getInt(1));
				bean.setAirlineName(rs.getString(2));

			} else {
				bean = null;
			}

		} catch (Exception e) {
			System.out.println("Error While fetching the Airline  details" + e.toString());
		}

		// retruning the admin bean
		return bean;
	}

	// changing the specified record
	public boolean changeAirline(Airline_Names bean) {
		boolean status = false;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "update airline_names set airlinename=? where airlineid=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, bean.getAirlineName());
			pst.setInt(2, bean.getAirlineId());
			int n = pst.executeUpdate();

			if (n > 0)
				status = true;

		} catch (Exception e) {
			System.out.println("Error While updating  the airline details" + e.toString());
		}

		return status;
	}

	// deleting the specified record
	public boolean deleteAirline(int airId) {
		boolean status = false;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "delete from airline_names where airlineid=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, airId);
			int n = pst.executeUpdate();

			if (n > 0)
				status = true;

		} catch (Exception e) {
			System.out.println("Error While deleting  Airlines record" + e.toString());
		}

		return status;
	}

	// inserting the new record in the db
	public boolean insertNewAirline(Airline_Names bean) {
		boolean status = false;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "insert into airline_names(airlinename) values(?)";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, bean.getAirlineName());

			System.out.println(bean);
			System.out.println(pst.toString());
			int n = pst.executeUpdate();

			if (n > 0)
				status = true;

		} catch (Exception e) {
			System.out.println("Error While entering record in source_and_destination " + e.toString());
		}

		return status;
	}

	/*
	 * main method to test the class public static void main(String[] args) {
	 * 
	 * Airline_Names b=new Airline_Names(); b.setAirlineName("King Fisher");
	 * System.out.println(new AirlinesDao().insertNewAirline(b)); }
	 * 
	 */
}
