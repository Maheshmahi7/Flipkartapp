package com.mahesh.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Order {
	private int id;
	private Customer customerId;
	private Product productId;
	private int quantity;
	private int totalCost;
	private LocalDate orderedDate;
	private String status;
	
}
