package com.mahesh.model;

import java.time.LocalDate;


public class TestOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order order=new Order();
		Customer customer=new Customer();
		Product product=new Product();
		order.setId(1);
		customer.setId(1);
		order.setCustomerId(customer);
		product.setId(1);
		order.setProductId(product);
		order.setQuantity(1);
		order.setTotalCost(35000);
		order.setOrderedDate(LocalDate.parse("2017-02-01"));
		order.setStatus("Deliverd");
		
		System.out.println(order);
		

	}

}
