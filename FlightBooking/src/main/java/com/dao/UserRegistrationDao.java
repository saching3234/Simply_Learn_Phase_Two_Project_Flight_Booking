package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.adminbeans.Flight;
import com.adminbeans.UserRegistration;
import com.util.DbConnection;

public class UserRegistrationDao {

	// getting the single record of registed user from db
	public UserRegistration getSingleUser(String userName) {
		UserRegistration bean = new UserRegistration();
		ResultSet rs = null;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "select * from userregistration where userName=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			rs = pst.executeQuery();

			// setting the result set into the bean
			if (rs.next()) {

				bean.setUserName(rs.getString(1));
				bean.setPassword(rs.getString(2));
				bean.setFullName(rs.getString(3));
				bean.setMobileNo(rs.getString(4));

			} else {
				bean = null;
			}

		} catch (Exception e) {
			System.out.println("Error While fetching the User Registration  details" + e.toString());
		}
		// retruning the user bean
		return bean;
	}

	// inserting the new record in the db
	public boolean insertNewUser(UserRegistration bean) {
		boolean status = false;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "INSERT INTO userregistration (userName,password, fullName, mobileNo) VALUES (?, ?, ?, ?);";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, bean.getUserName());
			pst.setString(2, bean.getPassword());
			pst.setString(3, bean.getFullName());
			pst.setString(4, bean.getMobileNo());

			int n = pst.executeUpdate();

			if (n > 0)
				status = true;

		} catch (Exception e) {
			System.out.println("Error While entering new record in User Registration " + e.toString());
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
