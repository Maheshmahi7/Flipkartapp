package com.mahesh.model;

import java.time.LocalDate;

public class TestProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product product=new Product();
		product.setId(1);
		product.setName("Samsung");
		product.setDescription("Mobile");
		product.setCost(35000);
		product.setReleasedDate(LocalDate.parse("2017-02-12"));
		product.setActive(1);
		
		System.out.println(product);
		
		

		
	}

}
