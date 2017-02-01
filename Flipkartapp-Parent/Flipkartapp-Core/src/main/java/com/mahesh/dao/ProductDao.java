package com.mahesh.dao;

import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;

import com.mahesh.model.Product;
import com.mahesh.util.ConnectionUtil;

public class ProductDao {
	
    JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();

	public void save(Product product) {

		String sql = "INSERT INTO FLIPKART_PRODUCTS(NAME,DESCRIPTION,COST,RELEASE_DATE) VALUES(?,?,?,?)";
		Object[] params = { product.getName(),product.getDescription(),product.getCost(),product.getReleasedDate() };
		jdbcTemplate.update(sql, params);
		
	}
	
	public void update(Product product) {

		String sql = "UPDATE FLIPKART_PRODUCTS SET NAME=?,DESCRIPTION=?,COST=? WHERE ID=?";
		Object[] params = { product.getName(),product.getDescription(),product.getCost(),product.getId() };
		jdbcTemplate.update(sql, params);
		
	}

	public void delete(int id) {

		String sql = "DELETE FROM FLIPKART_PRODUCTS WHERE ID=?";
		jdbcTemplate.update(sql, id);
		
	}
	public List<Product> list() {

		String sql = "SELECT ID,NAME,DESCRIPTION,COST,RELEASE_DATE,ACTIVE FROM FLIPKART_PRODUCTS";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			Product product=new Product();
			product.setId(rs.getInt("ID"));
			product.setName(rs.getString("NAME"));
			product.setDescription(rs.getString("DESCRIPTION"));
			product.setCost(rs.getInt("COST"));
			product.setReleasedDate(rs.getDate("RELEASE_DATE").toLocalDate());
			product.setActive(rs.getInt("ACTIVE"));
			return product;

		});
		

	}


}
