package com.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adminbeans.AdminLogin;
import com.adminbeans.Airline_Names;
import com.adminbeans.Flight;
import com.adminbeans.Source_To_Destination;
import com.adminbeans.UserRegistration;
import com.adminbeans.UserflightbookingDetails;
import com.dao.Source_To_Destination_Dao;
import com.services.Airline_Services;
import com.services.Flight_Service;
import com.services.UserFlightbookingDetailsServices;
import com.services.UserRegistrationService;

public class UserController extends HttpServlet {

	// logout code for user loged in
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("userSearchHomePage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String btnValue = request.getParameter("button");
		UserRegistrationService urs = new UserRegistrationService();
		Flight_Service fds = new Flight_Service();
		UserFlightbookingDetailsServices ufds = new UserFlightbookingDetailsServices();

		// redirecting to available Flights page
		if (btnValue.equals("serachFlight")) {

			// getting search details provided by user
			int personCount = Integer.parseInt(request.getParameter("txtpersoncount"));
			String jrDate = request.getParameter("jrDate");
			String routes = request.getParameter("ruotes");

			// seeting the journey date and person count in session
			HttpSession session = request.getSession();
			session.setAttribute("jrDate", jrDate);
			session.setAttribute("personCount", personCount);

			// spliting source to destination
			String source, destination;
			String sd[] = routes.split("=>");
			source = sd[0];
			destination = sd[1];
			// System.out.println(personCount+" "+jrDate+" "+source+" "+destination);

			List<Flight> flightList = new ArrayList<Flight>();
			// fetching the Master List Of airlines
			flightList = fds.getAll_S_D_MatchedFlights(source, destination);
			request.setAttribute("masterListOfFlights", flightList);
			RequestDispatcher rd = request.getRequestDispatcher("userAvailableFlights.jsp");
			rd.forward(request, response);

		}

		// redirecting to available loged user Flights page
		else if (btnValue.equals("logedUserserachFlight")) {

			// getting search details provided by user
			int personCount = Integer.parseInt(request.getParameter("txtpersoncount"));
			String jrDate = request.getParameter("jrDate");
			String routes = request.getParameter("ruotes");

			// seeting the journey date and person count in session
			HttpSession session = request.getSession();
			session.setAttribute("jrDate", jrDate);
			session.setAttribute("personCount", personCount);

			// spliting source to destination
			String source, destination;
			String sd[] = routes.split("=>");
			source = sd[0];
			destination = sd[1];
			// System.out.println(personCount+" "+jrDate+" "+source+" "+destination);

			List<Flight> flightList = new ArrayList<Flight>();
			// fetching the Master List Of airlines
			flightList = fds.getAll_S_D_MatchedFlights(source, destination);
			request.setAttribute("masterListOfFlights", flightList);
			RequestDispatcher rd = request.getRequestDispatcher("logedUserBookTicket.jsp");
			rd.forward(request, response);

		}

		// user login code

		else if (btnValue.equals("userLogin")) {
			// getting the login parameters provided by user
			String uname = request.getParameter("txtuname");
			String pass = request.getParameter("txtpass");
			UserRegistration bean = urs.getUserLogin(uname);
			if (bean != null) {
				// checking user name and password
				if (uname.equals(bean.getUserName()) && pass.equals(bean.getPassword())) {
					HttpSession session = request.getSession();
					// starting the session
					// HttpSession session=request.getSession();
					session.setAttribute("logedusername", bean.getUserName());
					session.setAttribute("logeduserFN", bean.getFullName());
					// forward to user dashboard page with flight booking details
					List<UserflightbookingDetails> userfltbdbeans = new ArrayList<UserflightbookingDetails>();
					userfltbdbeans = ufds.getAllBookedFlightsDetails(bean.getUserName());
					System.out.println(userfltbdbeans);
					request.setAttribute("userfltbdbeans", userfltbdbeans);

					RequestDispatcher rd = request.getRequestDispatcher("UserDashBoard.jsp");
					rd.forward(request, response);

				}

				// if credentials not matched redirect to login page
				else {
					RequestDispatcher rd = request.getRequestDispatcher("userLogin.jsp");
					request.setAttribute("err1", "Enter Valid User Name");
					request.setAttribute("err2", "Enter Valid Password");
					rd.forward(request, response);
					;
				}
			}

			// If user does not exist then redirect to login page again
			else {
				RequestDispatcher rd = request.getRequestDispatcher("userLogin.jsp");
				request.setAttribute("err1", "User doesnot exist");
				request.setAttribute("err2", "Enter Valid Password");
				rd.forward(request, response);
			}

		}

		// controller for book ticket
		else if (btnValue.equals("bookticket")) {
			// getting the flight id of selected flight id
			int flightId = Integer.parseInt(request.getParameter("fldid"));
			HttpSession session = request.getSession();
			// setting the flight id of selected flight id in session
			session.setAttribute("flightId", flightId);
			// forwarding to the user registration page
			RequestDispatcher rd = request.getRequestDispatcher("userRegistrationForm.jsp");
			rd.forward(request, response);

		}

		// code for payment successfull
		else if (btnValue.equals("paynow")) {

			int BookingId = Integer.parseInt(request.getParameter("BookingId").toString());

			if (ufds.updatePaymentStatus(BookingId, "true")) {
				RequestDispatcher rd = request.getRequestDispatcher("userPaymentSuccess.jsp");
				rd.forward(request, response);
			}
		}

		// code user dashboard
		else if (btnValue.equals("userDash")) {

			// forward to user dash board page with flight booking details
			HttpSession session = request.getSession();
			String username = session.getAttribute("logedusername").toString();
			List<UserflightbookingDetails> userfltbdbeans = new ArrayList<UserflightbookingDetails>();
			userfltbdbeans = ufds.getAllBookedFlightsDetails(username);
			System.out.println(userfltbdbeans);
			request.setAttribute("userfltbdbeans", userfltbdbeans);

			RequestDispatcher rd = request.getRequestDispatcher("UserDashBoard.jsp");
			rd.forward(request, response);

		}

		// controller for booking logged user
		else if (btnValue.equals("logedUserBookticket")) {

			// inserting the flight booking detail into the userflight booking table
			HttpSession session = request.getSession();
			int flightId = Integer.parseInt(request.getParameter("fldid"));
			int pscount = Integer.parseInt(session.getAttribute("personCount").toString());
			String jrDate = session.getAttribute("jrDate").toString();

			Flight f = fds.getSingleMatchedFlight(flightId);

			UserflightbookingDetails ufb = new UserflightbookingDetails();
			// setting the details into the bean
			ufb.setFlightId(f.getFlight_Id());
			ufb.setFlightSource(f.getFSource());
			ufb.setFlightDestinatio(f.getFDestinatiom());
			ufb.setAirLineName(f.getAirlineName());
			ufb.setTicketPrice(f.getTicket_Price());
			ufb.setPassangerCount(pscount);
			ufb.setFinalPrice(f.getTicket_Price() * pscount);
			ufb.setPaymentStatus("false");
			ufb.setDateofjourney(jrDate);
			ufb.setUserName(session.getAttribute("logedusername").toString());

			// saving booking details
			if (ufds.addNewFlight(ufb)) {

				// forward to user dashboard page with flight booking details
				List<UserflightbookingDetails> userfltbdbeans = new ArrayList<UserflightbookingDetails>();
				userfltbdbeans = ufds.getAllBookedFlightsDetails(session.getAttribute("logedusername").toString());
				System.out.println(userfltbdbeans);
				request.setAttribute("userfltbdbeans", userfltbdbeans);

				RequestDispatcher rd = request.getRequestDispatcher("UserDashBoard.jsp");
				rd.forward(request, response);
			}

			else {
				System.out.println("There is some error while entering flight booking details");
			}

		}

		// code user registration
		else if (btnValue.equals("userReg")) {
			// geting value from the user form
			String username = request.getParameter("txtuname");
			String password = request.getParameter("txtpass");
			String fullname = request.getParameter("txtfname");
			String mobile = request.getParameter("mobile");

			// setting value to user bean
			UserRegistration ur = new UserRegistration();
			ur.setFullName(fullname);
			ur.setUserName(username);
			ur.setPassword(password);
			ur.setMobileNo(mobile);

			// inserting the data in the user registration db
			if (urs.registerUser(ur)) {

				// inserting the flight booking detail into the userflight booking table
				HttpSession session = request.getSession();
				int flightId = Integer.parseInt(session.getAttribute("flightId").toString());
				int pscount = Integer.parseInt(session.getAttribute("personCount").toString());
				String jrDate = session.getAttribute("jrDate").toString();

				Flight f = fds.getSingleMatchedFlight(flightId);

				UserflightbookingDetails ufb = new UserflightbookingDetails();
				// setting the details into the bean
				ufb.setFlightId(f.getFlight_Id());
				ufb.setFlightSource(f.getFSource());
				ufb.setFlightDestinatio(f.getFDestinatiom());
				ufb.setAirLineName(f.getAirlineName());
				ufb.setTicketPrice(f.getTicket_Price());
				ufb.setPassangerCount(pscount);
				ufb.setFinalPrice(f.getTicket_Price() * pscount);
				ufb.setPaymentStatus("false");
				ufb.setDateofjourney(jrDate);
				ufb.setUserName(username);

				// saving booking details
				if (ufds.addNewFlight(ufb)) {

					// starting the session
					// HttpSession session=request.getSession();
					session.setAttribute("logedusername", ur.getUserName());
					session.setAttribute("logeduserFN", ur.getFullName());

					// forward to user dashboard page with flight booking details
					List<UserflightbookingDetails> userfltbdbeans = new ArrayList<UserflightbookingDetails>();
					userfltbdbeans = ufds.getAllBookedFlightsDetails(username);
					System.out.println(userfltbdbeans);
					request.setAttribute("userfltbdbeans", userfltbdbeans);

					RequestDispatcher rd = request.getRequestDispatcher("UserDashBoard.jsp");
					rd.forward(request, response);
				}

				else {
					System.out.println("There is some error while entering flight booking details");
				}

			}

			// error while entering the registration details
			else {
				System.out.println("Error while entering user detaisl");
			}

		}

	}

}