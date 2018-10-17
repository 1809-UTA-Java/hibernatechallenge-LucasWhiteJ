package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.Util.ConnectionUtil;
import com.revature.model.Customer;;

public class CustomerDao {

	public List<Customer> getCustomers() {
		//Hibernate version
		Session session = ConnectionUtil.getSession();
		return session.createQuery("from Customer").list();
	}
	
	public void addNewCustomer(String name, String userName, String password) {
		//Hibernate version
		
	}
	
	public Customer getCustByUserName(String uName) {
		Customer found = null;
		List<Customer> customers = new ArrayList<>();
		Session session = ConnectionUtil.getSession();
		
		customers = session.createQuery("from Customer where custusername = :username").setString("username", uName).list();
		if (!customers.isEmpty()) {
			found = customers.get(0);
		}
		return found;
	}
}
