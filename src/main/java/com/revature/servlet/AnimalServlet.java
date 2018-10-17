package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.revature.Util.ConnectionUtil;
import com.revature.model.Customer;
import com.revature.repository.CustomerDao;

@WebServlet("/customers")
public class AnimalServlet extends HttpServlet {
	List<Customer> customers;
	CustomerDao dao = new CustomerDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// customers = dao.getCustomers();
		resp.setContentType("text");
		ObjectMapper om = new XmlMapper();
		// String obj = om.writeValueAsString(customers);
		String obj = om.writeValueAsString(dao.getCustByUserName("coral"));
		PrintWriter pw = resp.getWriter();
		pw.print(obj);
		pw.close();
	}

	/*
	 * protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	 * throws ServletException, IOException { ObjectMapper om = new XmlMapper();
	 * Customer postCustomer = (Customer) om.readValue(req.getInputStream(),
	 * Customer.class); PrintWriter pw = resp.getWriter();
	 * pw.print(dao.saveCustomer(postCustomer)); pw.close(); }
	 */

	@Override
	public void destroy() {
		ConnectionUtil.shutdown();
	}
}
