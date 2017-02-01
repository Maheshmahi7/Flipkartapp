package com.mahesh.dao;

import java.util.Iterator;
import java.util.List;

import com.mahesh.model.Customer;

public class TestCustomerDao {
	public static void main(String[] args) {
		CustomerDao customerDao=new CustomerDao();
		
		List<Customer> list = customerDao.list();
		Iterator<Customer> i = list.iterator();
		while (i.hasNext()) {
			Customer customer=(Customer) i.next();
			System.out.println(customer.getId()+"\t"+customer.getName()+"\t"+customer.getEmailId()+"\t"+customer.getPassword()
			+"\t"+customer.getAddress()+"\t"+customer.getActive());
		}
		
	}

}
