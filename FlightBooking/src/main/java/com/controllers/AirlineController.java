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
import com.adminbeans.Source_To_Destination;
import com.services.Airline_Services;

public class AirlineController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String btnValue = request.getParameter("button");
		Airline_Services airser = new Airline_Services();

		// controller for inserting the new airline
		if (btnValue.equals("airInsertNew")) {
			// getting airline name parameters provided by user
			String airlineName = request.getParameter("txtAirlineName");

			Airline_Names bean = new Airline_Names();
			bean.setAirlineName(airlineName);

			if (airser.insertNew_Airline(bean)) {
				String msg = "<div class=\"alert alert-dismissible alert-success\">\r\n"
						+ "					<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\"></button>\r\n"
						+ "					<strong>Well done!</strong> New Airline Successfully Inserted \r\n"
						+ "				</div>";
				request.setAttribute("msg", msg);
			} else {
				request.setAttribute("msg", false);
			}

			// redirecting to the same page
			RequestDispatcher rd = request.getRequestDispatcher("masterListOfAirlinesInsertNew.jsp");
			rd.forward(request, response);
		}

		// controller for deleting the airline record
		else if (btnValue.equals("delete")) {
			// getting the lblairid provided by user
			System.out.println("The value Of label " + request.getParameter("lblairid"));

			int airId = Integer.parseInt(request.getParameter("lblairid"));

			if (airser.delete_Airline(airId)) {
				String msg = "<div class=\"alert alert-dismissible alert-success\">\r\n"
						+ "					<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\"></button>\r\n"
						+ "					<strong>Well done!</strong> Airline Deleted Successfully  \r\n"
						+ "				</div>";
				request.setAttribute("msg", msg);
			}

			List<Airline_Names> airList = new ArrayList<Airline_Names>();
			// fetching the Master List Of airlines
			airList = airser.getAll_Airlines();
			request.setAttribute("masterListOfAirlines", airList);
			RequestDispatcher rd = request.getRequestDispatcher("masterListOfAirlines.jsp");
			rd.forward(request, response);

		}

		// edit controller for redirecting to page
		else if (btnValue.equals("airEdit")) {

			int airid = Integer.parseInt(request.getParameter("lblairid"));

			// fetching the record from db of specified airline
			Airline_Names bean = airser.edit_Airline(airid);
			request.setAttribute("edit_air_Record", bean);
			System.out.println(bean);

			RequestDispatcher rd = request.getRequestDispatcher("masterListOfAirlinesEdit.jsp");
			rd.forward(request, response);

		}

		// controller for updating airlines
		else if (btnValue.equals("update")) {

			// getting the login parameters provided by user
			String txtAirlineName = request.getParameter("txtAirlineName");

			int airId = Integer.parseInt(request.getParameter("airId"));

			// setting a bean object
			Airline_Names bean = new Airline_Names();
			bean.setAirlineName(txtAirlineName);
			bean.setAirlineId(airId);

			// executing the query
			if (airser.update_Airline(bean)) {
				String msg = "<div class=\"alert alert-dismissible alert-success\">\r\n"
						+ "					<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\"></button>\r\n"
						+ "					<strong>Well done!</strong>Airline Name Updated Successfully \r\n"
						+ "				</div>";
				request.setAttribute("msg", msg);
			} else {
				request.setAttribute("msg", false);
			}

			// redireting to page edit page
			RequestDispatcher rd = request.getRequestDispatcher("masterListOfAirlinesEdit.jsp");
			rd.forward(request, response);

		}

		// redirecting to master list of airlines page
		else if (btnValue.equals("masterListOfAirlines")) {

			List<Airline_Names> airList = new ArrayList<Airline_Names>();
			// fetching the Master List Of airlines
			airList = airser.getAll_Airlines();
			request.setAttribute("masterListOfAirlines", airList);
			RequestDispatcher rd = request.getRequestDispatcher("masterListOfAirlines.jsp");
			rd.forward(request, response);

		}

	}
}
