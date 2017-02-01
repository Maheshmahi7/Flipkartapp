package com.mahesh.dao;

import java.util.Iterator;
import java.util.List;

import com.mahesh.model.Product;

public class TestProductDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProductDao productDao=new ProductDao();
		
		List<Product> list= productDao.list();
		Iterator<Product> i= list.iterator();
		while(i.hasNext()){
			Product product=(Product) i.next();
			System.out.println(product.getId()+"\t"+product.getName()+"\t"+product.getDescription()+"\t"+product.getCost()
			+"\t"+product.getReleasedDate()+"\t"+product.getActive());
		}
				

	}

}
