package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.adminbeans.Source_To_Destination;
import com.util.DbConnection;

public class Source_To_Destination_Dao {

	// get all records from the db
	public List<Source_To_Destination> getAll_Source_To_Destination() {
		List<Source_To_Destination> beans = new ArrayList<Source_To_Destination>();
		ResultSet rs = null;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "select * from source_and_destination";
			PreparedStatement pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			// setting the result set into the bean
			while (rs.next()) {
				Source_To_Destination bean = new Source_To_Destination();
				bean.setSdid(rs.getInt(1));
				bean.setSource(rs.getString(2));
				bean.setDestination(rs.getString(3));
				beans.add(bean);
			}

		} catch (Exception e) {
			System.out.println("Error While fetching the Source_To_Destination  details" + e.toString());
		}
		return beans;
	}

	// getting the single record from db
	public Source_To_Destination getSource_To_Destination(int sdid) {
		Source_To_Destination bean = new Source_To_Destination();
		ResultSet rs = null;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "select * from source_and_destination where sdid=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, sdid);
			rs = pst.executeQuery();

			// setting the result set into the bean
			if (rs.next()) {
				bean.setSdid(rs.getInt(1));
				bean.setSource(rs.getString(2));
				bean.setDestination(rs.getString(3));
			} else {
				bean = null;
			}

		} catch (Exception e) {
			System.out.println("Error While fetching the Source_To_Destination  details" + e.toString());
		}

		// retruning the admin bean
		return bean;
	}

	// changing the specified record
	public boolean changeSource_To_Destinations(Source_To_Destination bean) {
		boolean status = false;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "update source_and_destination set source=?,destination=? where sdid=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, bean.getSource());
			pst.setString(2, bean.getDestination());
			pst.setInt(3, bean.getSdid());
			int n = pst.executeUpdate();

			if (n > 0)
				status = true;

		} catch (Exception e) {
			System.out.println("Error While fetching the admin details" + e.toString());
		}

		return status;
	}

	// deleting the specified record
	public boolean deleteSource_To_Destinations(int sdid) {
		boolean status = false;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "delete from source_and_destination where sdid=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, sdid);
			int n = pst.executeUpdate();

			if (n > 0)
				status = true;

		} catch (Exception e) {
			System.out.println("Error While deleting  source_and_destination record" + e.toString());
		}

		return status;
	}

	// inserting the new record in the db
	public boolean insertSource_To_Destinations(Source_To_Destination bean) {
		boolean status = false;
		try {
			Connection con = DbConnection.mysqlConnectio();
			String sql = "insert into source_and_destination(source,destination) values(?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, bean.getSource());
			pst.setString(2, bean.getDestination());

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

}
