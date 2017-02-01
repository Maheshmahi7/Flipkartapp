package com.mahesh.dao;

import java.util.Iterator;
import java.util.List;

import com.mahesh.model.Order;

public class TestOrderDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderDao orderDao=new OrderDao();
		
		List<Order> list= orderDao.list();
		Iterator<Order> i= list.iterator();
		while(i.hasNext()){
			Order order=(Order) i.next();
			System.out.println(order.getId()+"\t"+order.getCustomerId().getId()+"\t"+order.getProductId().getId()+"\t"+order.getQuantity()
			+"\t"+order.getTotalCost()+"\t"+order.getOrderedDate()+"\t"+order.getStatus());
		}

	}

}
