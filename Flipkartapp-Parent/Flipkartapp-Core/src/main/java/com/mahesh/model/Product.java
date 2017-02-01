package com.mahesh.model;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Product {
	private int id;
	private String name;
	private String description;
	private int cost;
	private LocalDate releasedDate;
	private int active;

}
