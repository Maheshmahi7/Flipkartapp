package com.mahesh.model;

import lombok.Data;

@Data
public class Customer {
	private int id;
	private String name;
	private String emailId;
	private String password;
	private String address;
	private int active;

}
