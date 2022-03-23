package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.adminbeans.AdminLogin;
//import java.sql.Resultset;
import com.util.DbConnection;

public class AdminLoginDao {

	public AdminLogin getLogin(String adminName) {
		AdminLogin bean = new AdminLogin();
		ResultSet rs = null;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "select * from adminlogin where adminName=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, adminName);
			rs = pst.executeQuery();

			// setting the result set into the bean
			if (rs.next()) {
				bean.setAdminName(rs.getString(1));
				bean.setAdminPass(rs.getString(2));
			} else {
				bean = null;
			}

		} catch (Exception e) {
			System.out.println("Error While fetching the admin details" + e.toString());
		}

		// retruning the admin bean
		return bean;

	}

	public boolean changePass(String userName, String password) {
		boolean status = false;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "update adminlogin set adminpass=? where adminName=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, password);
			pst.setString(2, userName);
			int n = pst.executeUpdate();

			if (n > 0)
				status = true;

		} catch (Exception e) {
			System.out.println("Error While fetching the admin details" + e.toString());
		}

		return status;
	}

}
