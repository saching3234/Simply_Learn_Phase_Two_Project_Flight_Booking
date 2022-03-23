package com.services;

import java.util.List;

import com.adminbeans.UserflightbookingDetails;
import com.dao.UserFlightbookingDetailsDao;

public class UserFlightbookingDetailsServices {
	UserFlightbookingDetailsDao dao=new UserFlightbookingDetailsDao();
	
	public List<UserflightbookingDetails> getAllBookedFlightsDetails(String userName) {
	    return dao.getAllBookedFlights(userName);
	}
	
	
	public boolean updatePaymentStatus(int bookingId,String PaymentStatus) {
	
	return dao.changePaymentStatus(bookingId, PaymentStatus);
	}
	
	public boolean addNewFlight(UserflightbookingDetails bean) {

		return dao.insertNewFlight(bean);
	}	

}
