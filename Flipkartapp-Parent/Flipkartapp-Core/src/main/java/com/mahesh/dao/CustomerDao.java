package com.mahesh.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mahesh.model.Customer;
import com.mahesh.util.ConnectionUtil;

public class CustomerDao {
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(Customer customer) {

		String sql = "INSERT INTO FLIPKART_CUSTOMERS(NAME,EMAIL_ID,PASSWORD,ADDRESS) VALUES(?,?,?,?)";
		Object[] params = { customer.getName(),customer.getEmailId(),customer.getPassword(),customer.getAddress() };
		jdbcTemplate.update(sql, params);

	}
	
	public void update(Customer customer) {

		String sql = "UPDATE FLIPKART_CUSTOMERS SET NAME=?,ADDRESS=? WHERE ID=?";
		Object[] params = { customer.getName(),customer.getAddress(),customer.getId() };
		jdbcTemplate.update(sql, params);


	}

	public void delete(int id) {

		String sql = "DELETE FROM FLIPKART_CUSTOMERS WHERE ID=?";
		jdbcTemplate.update(sql, id);
		
	}
	public List<Customer> list() {

		String sql = "SELECT ID,NAME,EMAIL_ID,PASSWORD,ADDRESS,ACTIVE FROM FLIPKART_CUSTOMERS";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			Customer customer=new Customer();
			customer.setId(rs.getInt("ID"));
			customer.setName(rs.getString("NAME"));
			customer.setEmailId(rs.getString("EMAIL_ID"));
			customer.setPassword(rs.getString("PASSWORD"));
			customer.setAddress(rs.getString("ADDRESS"));
			customer.setActive(rs.getInt("ACTIVE"));
			return customer;

		});

	}


}
