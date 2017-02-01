package com.mahesh.model;

public class TestCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer customer=new Customer();
		customer.setId(1);
		customer.setName("Mahesh");
		customer.setEmailId("mahesh11317@gmail.com");
		customer.setPassword("maheshkumar");
		customer.setAddress("Tiruppur");
		customer.setActive(1);
		
		System.out.println(customer.getName());

	}

}
