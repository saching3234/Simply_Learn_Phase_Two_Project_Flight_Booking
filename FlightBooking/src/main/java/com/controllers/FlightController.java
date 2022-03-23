package com.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adminbeans.Airline_Names;
import com.adminbeans.Flight;
import com.adminbeans.Source_To_Destination;
import com.dao.Source_To_Destination_Dao;
import com.services.Airline_Services;
import com.services.Flight_Service;

public class FlightController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Airline_Services airser = new Airline_Services();
		Source_To_Destination_Dao sdo = new Source_To_Destination_Dao();
		// getting the all airlines
		List<Airline_Names> airList = new ArrayList<Airline_Names>();
		// fetching the Master List Of airlines
		airList = airser.getAll_Airlines();
		request.setAttribute("masterListOfAirlines", airList);

		// getting the all source to destinations routes
		List<Source_To_Destination> s_dList = new ArrayList<Source_To_Destination>();
		// fetching the Master List Of airlines
		s_dList = sdo.getAll_Source_To_Destination();
		request.setAttribute("s_dList", s_dList);

		// redirecting to the same page
		RequestDispatcher rd = request.getRequestDispatcher("masterListFlightNewInsert.jsp");
		rd.forward(request, response);
		// System.out.println("Method Called");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String btnValue = request.getParameter("button");
		Airline_Services airser = new Airline_Services();
		Flight_Service fds = new Flight_Service();

		// controller for inserting the new airline
		if (btnValue.equals("flightInsertNew")) {
			// getting airline name parameters provided by user
			int price = Integer.parseInt(request.getParameter("txtprice"));
			String airlineName = request.getParameter("airlines");
			String routes = request.getParameter("ruotes");
			String source, destination;
			String sd[] = routes.split("=>");
			source = sd[0];
			destination = sd[1];
			System.out.println(price + " " + airlineName + " " + source + " " + destination);

			// setting the bean values of flight
			Flight bean = new Flight();
			bean.setAirlineName(airlineName);
			bean.setFDestinatiom(destination);
			bean.setFSource(source);
			bean.setTicket_Price(price);

			if (fds.insertNew_Flight(bean)) {
				String msg = "<div class=\"alert alert-dismissible alert-success\">\r\n"
						+ "					<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\"></button>\r\n"
						+ "					<strong>Well done!</strong> New Flight Added Successfully  \r\n"
						+ "				</div>";
				request.setAttribute("msg", msg);
			} else {
				request.setAttribute("msg", false);
			}

			Source_To_Destination_Dao sdo = new Source_To_Destination_Dao();
			// getting the all airlines
			List<Airline_Names> airList = new ArrayList<Airline_Names>();
			// fetching the Master List Of airlines
			airList = airser.getAll_Airlines();
			request.setAttribute("masterListOfAirlines", airList);

			// getting the all source to destinations routes
			List<Source_To_Destination> s_dList = new ArrayList<Source_To_Destination>();
			// fetching the Master List Of airlines
			s_dList = sdo.getAll_Source_To_Destination();
			request.setAttribute("s_dList", s_dList);

			// redirecting to the same page
			RequestDispatcher rd = request.getRequestDispatcher("masterListFlightNewInsert.jsp");
			rd.forward(request, response);
			// System.out.println("Method Called");

		}

		// controller for deleting the flight record
		else if (btnValue.equals("delete")) {

			// getting the Flight Id provided by user
			int fldid = Integer.parseInt(request.getParameter("fldid"));

			if (fds.delete_Flight(fldid)) {
				String msg = "<div class=\"alert alert-dismissible alert-success\">\r\n"
						+ "					<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\"></button>\r\n"
						+ "					<strong>Well done!</strong> Flight Deleted Successfully  \r\n"
						+ "				</div>";
				request.setAttribute("msg", msg);
			}

			// fetching the Master List Of Flights
			List<Flight> flightList = new ArrayList<Flight>();

			flightList = fds.getAll_Flights();
			request.setAttribute("masterListOfFlights", flightList);
			RequestDispatcher rd = request.getRequestDispatcher("masterListOfFlights.jsp");
			rd.forward(request, response);
		}

		// edit controller for redirecting to edit page
		else if (btnValue.equals("flightEdit")) {

			int flightId = Integer.parseInt(request.getParameter("fldid"));

			// fetching the record from db of specified airline
			Flight bean = fds.edit_Flight(flightId);
			request.setAttribute("edit_flight_Record", bean);

			RequestDispatcher rd = request.getRequestDispatcher("masterListOfFlightEdit.jsp");
			rd.forward(request, response);

		}

		// controller for updating airlines
		else if (btnValue.equals("update")) {

			// getting the flight parameters updated by user

			String txtsource = request.getParameter("txtsource");
			String txtdestination = request.getParameter("txtdestination");
			String txtAirlineName = request.getParameter("txtairlinenm");
			int ticketPrice = Integer.parseInt(request.getParameter("txtprice"));
			int fligtId = Integer.parseInt(request.getParameter("fltId"));

			// setting a bean object
			Flight bean = new Flight();
			bean.setFSource(txtsource);
			bean.setFDestinatiom(txtdestination);
			bean.setAirlineName(txtAirlineName);
			bean.setTicket_Price(ticketPrice);
			bean.setFlight_Id(fligtId);

			// executing the query
			if (fds.update_Flight(bean)) {
				String msg = "<div class=\"alert alert-dismissible alert-success\">\r\n"
						+ "					<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\"></button>\r\n"
						+ "					<strong>Well done!</strong>Flight Details Updated Successfully \r\n"
						+ "				</div>";
				request.setAttribute("msg", msg);
			} else {
				request.setAttribute("msg", false);
			}

			// redireting to same page edit page
			RequestDispatcher rd = request.getRequestDispatcher("masterListOfFlightEdit.jsp");
			rd.forward(request, response);

		}

		// redirecting to master list of Flights page
		else if (btnValue.equals("masterListOfFlight")) {

			List<Flight> flightList = new ArrayList<Flight>();
			// fetching the Master List Of airlines
			flightList = fds.getAll_Flights();
			request.setAttribute("masterListOfFlights", flightList);
			RequestDispatcher rd = request.getRequestDispatcher("masterListOfFlights.jsp");
			rd.forward(request, response);

		}

	}

}
