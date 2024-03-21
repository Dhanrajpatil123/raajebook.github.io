package com.dao;

import java.util.List;

import com.entity.Book_Order;

public interface BookOrderDao {

	
//	public int getBookOrderNo();
	
	public boolean saveOrder(List<Book_Order> blist);
	
	public List<Book_Order> getBook(String email);

	public List<Book_Order> getAllOrder();
	
	
}
