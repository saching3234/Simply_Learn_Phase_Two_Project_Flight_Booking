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
import com.dao.FlightDao;
import com.mysql.cj.Session;
import com.services.AdminServices;
import com.services.Airline_Services;
import com.services.Source_To_Destination_Services;

public class AdminController extends HttpServlet {
	Source_To_Destination_Services s_d = new Source_To_Destination_Services();
	FlightDao fd = new FlightDao();

	Airline_Services air_ser = new Airline_Services();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("adminLogin.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String btnValue = request.getParameter("button");

		AdminServices as = new AdminServices();

		if (btnValue.equals("adminLogin")) {
			// getting the login parameters provided by user
			String uname = request.getParameter("txtuname");
			String pass = request.getParameter("txtpass");
			AdminLogin bean = as.getLogin(uname);
			if (bean != null) {
				// checking user name and password
				if (uname.equals(bean.getAdminName()) && pass.equals(bean.getAdminPass())) {
					HttpSession session = request.getSession();
					session.setAttribute("adminname", uname);
					RequestDispatcher rd = request.getRequestDispatcher("adminHome.jsp");
					rd.forward(request, response);

				}

				// if credentials not matched redirect to login page
				else {
					RequestDispatcher rd = request.getRequestDispatcher("adminLogin.jsp");
					request.setAttribute("err1", "Enter Valid User Name");
					request.setAttribute("err2", "Enter Valid Password");
					rd.forward(request, response);
					;
				}
			}

			// If user does not exist then redirect to login page again
			else {
				RequestDispatcher rd = request.getRequestDispatcher("adminLogin.jsp");
				request.setAttribute("err1", "Enter Valid User Name");
				request.setAttribute("err2", "Enter Valid Password");
				rd.forward(request, response);
			}

		}

		// redirecting to master list of places page
		else if (btnValue.equals("masterListOfPlaces")) {

			List<Source_To_Destination> sd = new ArrayList<Source_To_Destination>();
			// fetching the Master List Of places for source to destination
			sd = s_d.getAll_S_To_D();
			request.setAttribute("masterListOfPlaces", sd);
			RequestDispatcher rd = request.getRequestDispatcher("masterListOfPlaces.jsp");
			rd.forward(request, response);

		}

		// redirecting to master list of Flights page
		else if (btnValue.equals("masterListOfFlights")) {

			List<Flight> flt = new ArrayList<Flight>();
			// fetching the Master List Of FLights
			flt = fd.getFlights();
			request.setAttribute("masterListOfFlights", flt);
			RequestDispatcher rd = request.getRequestDispatcher("masterListOfFlights.jsp");
			rd.forward(request, response);

		}

		else if (btnValue.equals("masterListOfAirlines")) {
			List<Airline_Names> airList = new ArrayList<Airline_Names>();
			// fetching the Master List Of places for source to destination
			airList = air_ser.getAll_Airlines();
			request.setAttribute("masterListOfAirlines", airList);
			RequestDispatcher rd = request.getRequestDispatcher("masterListOfAirlines.jsp");
			rd.forward(request, response);
		}

		// redirecting to the admin password change page
		else if (btnValue.equals("changePass")) {
			RequestDispatcher rd = request.getRequestDispatcher("adminChangePassword.jsp");
			rd.forward(request, response);

		} else if (btnValue.equals("changePassConfirmation")) {
			// getting the admin name and password
			HttpSession session = request.getSession();
			String uname = session.getAttribute("adminname").toString();
			String oldPass = request.getParameter("txtpassold");
			String newPass1 = request.getParameter("txtpassnew1");
			String newPass2 = request.getParameter("txtpassnew2");

			// checking password is eight length or not
			if (request.getParameter("txtpassold").length() != 8 || request.getParameter("txtpassnew1").length() != 8
					|| request.getParameter("txtpassnew2").length() != 8) {
				request.setAttribute("newPassError1", "password must be of eight length ");
				request.setAttribute("oldPassErr", "password must be of eight length");
				request.setAttribute("newPassError2", "password must be of eight length ");

				RequestDispatcher rd = request.getRequestDispatcher("adminChangePassword.jsp");
				rd.forward(request, response);
			}

			else {
				AdminLogin bean = as.getLogin(uname);

				// checking the old password
				if (bean.getAdminPass().equals(oldPass)) {
					// checking the new passwords
					if (newPass1.equals(newPass2)) {
						// changing the password in the database

						if (as.changePassword(uname, newPass2)) {
							HttpSession session1 = request.getSession();
							session1.invalidate();
							RequestDispatcher rd = request.getRequestDispatcher("adminPassChangeSuccess.jsp");
							rd.forward(request, response);
						}

					} else {
						request.setAttribute("newPassError2", "New password does not matches with Re-Enter Password");
						RequestDispatcher rd = request.getRequestDispatcher("adminChangePassword.jsp");
						rd.forward(request, response);
					}
				} else {
					request.setAttribute("oldPassErr", "Old password does not matches.Check Old Password");
					RequestDispatcher rd = request.getRequestDispatcher("adminChangePassword.jsp");
					rd.forward(request, response);

				}
			}
		}

	}

}
