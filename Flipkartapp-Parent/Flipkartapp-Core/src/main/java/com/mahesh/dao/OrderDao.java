package com.mahesh.dao;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.mahesh.model.Customer;
import com.mahesh.model.Order;
import com.mahesh.model.Product;
import com.mahesh.util.ConnectionUtil;

public class OrderDao {
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();

	public String PR_ORDER_PRODUCT(int customerId,int productId ,int quantity) {

		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate);
		call.withProcedureName("PR_ORDER_PRODUCT");
		call.declareParameters(new SqlParameter("I_CUSTOMER_ID", Types.INTEGER),new SqlParameter("I_PRODUCT_ID", Types.INTEGER),
				new SqlParameter("I_QUANTITY", Types.INTEGER),
				new SqlOutParameter("O_MESSAGE", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);

		MapSqlParameterSource in = new MapSqlParameterSource();
		in.addValue("I_CUSTOMER_ID", customerId);
		in.addValue("I_PRODUCT_ID", productId);
		in.addValue("I_QUANTITY", quantity);

		Map<String, Object> execute = call.execute(in);

		String status = (String) execute.get("O_MESSAGE");
		return status;

	}
	


	public void delete(int id) {

		String sql = "DELETE FROM FLIPKART_ORDERS WHERE ID=?";
		jdbcTemplate.update(sql, id);
		
	}
	public List<Order> list() {

		String sql = "SELECT ID,CUSTOMER_ID,PRODUCT_ID,QUANTITY,TOTAL_AMOUNT,ORDERED_DATE,STATUS FROM FLIPKART_ORDERS";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			Order order=new Order();
			order.setId(rs.getInt("ID"));
			Customer customer=new Customer();
			customer.setId(rs.getInt("CUSTOMER_ID"));
			order.setCustomerId(customer);
			Product product=new Product();
			product.setId(rs.getInt("PRODUCT_ID"));
			order.setProductId(product);
			order.setQuantity(rs.getInt("QUANTITY"));
			order.setTotalCost(rs.getInt("TOTAL_AMOUNT"));
			order.setOrderedDate(rs.getDate("ORDERED_DATE").toLocalDate());
			order.setStatus(rs.getString("STATUS"));
			return order;

		});


}
}
