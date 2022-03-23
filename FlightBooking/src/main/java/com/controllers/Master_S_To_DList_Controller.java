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
import com.adminbeans.Source_To_Destination;
import com.services.AdminServices;
import com.services.Source_To_Destination_Services;

public class Master_S_To_DList_Controller extends HttpServlet {
	Source_To_Destination_Services s_d = new Source_To_Destination_Services();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String btnValue = request.getParameter("button");
		Source_To_Destination_Services sd = new Source_To_Destination_Services();

		if (btnValue.equals("sdInsert")) {
			// getting the login parameters provided by user
			String source = request.getParameter("txtsource");
			String dest = request.getParameter("txtdestination");
			Source_To_Destination bean = new Source_To_Destination();
			bean.setDestination(dest);
			bean.setSource(source);

			if (sd.insertNew_Source_To_Destination_Services(bean)) {
				String msg = "<div class=\"alert alert-dismissible alert-success\">\r\n"
						+ "					<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\"></button>\r\n"
						+ "					<strong>Well done!</strong> New Route Successfully Inserted \r\n"
						+ "				</div>";
				request.setAttribute("msg", msg);
			} else {
				request.setAttribute("suceess", false);
			}

			RequestDispatcher rd = request.getRequestDispatcher("masterListOfPlacesInsertNew.jsp");
			rd.forward(request, response);

		} else if (btnValue.equals("delete")) {
			// getting the sdid provided by user
			System.out.println("The value Of label " + request.getParameter("lblsdid"));

			int sid = Integer.parseInt(request.getParameter("lblsdid"));

			if (sd.deletes_d(sid)) {
				String msg = "<div class=\"alert alert-dismissible alert-success\">\r\n"
						+ "					<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\"></button>\r\n"
						+ "					<strong>Well done!</strong> Route Deleted Successfully  \r\n"
						+ "				</div>";
				request.setAttribute("msg", msg);
			}

			List<Source_To_Destination> sdList = new ArrayList<Source_To_Destination>();
			// fetching the Master List Of places for source to destination
			sdList = s_d.getAll_S_To_D();
			request.setAttribute("masterListOfPlaces", sdList);
			RequestDispatcher rd = request.getRequestDispatcher("masterListOfPlaces.jsp");
			rd.forward(request, response);

		}

		else if (btnValue.equals("edit")) {
			// getting the sdid provided by user
			System.out.println("The value Of label " + request.getParameter("lblsdid"));

			int sid = Integer.parseInt(request.getParameter("lblsdid"));

			// fetching the the from db of specified route add
			Source_To_Destination bean = s_d.edits_d(sid);
			request.setAttribute("editS_D_Record", bean);

			RequestDispatcher rd = request.getRequestDispatcher("masterListOfPlacesEdit.jsp");
			rd.forward(request, response);

		}

		else if (btnValue.equals("update")) {

			// getting the login parameters provided by user
			String source = request.getParameter("txtsource");
			String dest = request.getParameter("txtdestination");
			int sdid = Integer.parseInt(request.getParameter("sdid"));
			Source_To_Destination bean = new Source_To_Destination();
			bean.setDestination(dest);
			bean.setSource(source);
			bean.setSdid(sdid);

			if (sd.update_Source_To_Destination_Services(bean)) {
				String msg = "<div class=\"alert alert-dismissible alert-success\">\r\n"
						+ "					<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\"></button>\r\n"
						+ "					<strong>Well done!</strong>Route Updated Successfully \r\n"
						+ "				</div>";
				request.setAttribute("msg", msg);
			} else {
				request.setAttribute("suceess", false);
			}

			RequestDispatcher rd = request.getRequestDispatcher("masterListOfPlacesEdit.jsp");
			rd.forward(request, response);

		}

	}

}
