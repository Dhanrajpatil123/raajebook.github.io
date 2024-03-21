package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Book_Order;

public class BookOrderImplementation implements BookOrderDao{

	
	
	
	private Connection con;

	public BookOrderImplementation(Connection con) {
		super();
		this.con = con;
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings("unused")
	public boolean saveOrder(List<Book_Order> blist) {
		
		boolean f = false;
		
		
		
		try {
		
			
			String query = "insert into book_order (orderid, username, email, address, phone, bookname, author, price, payment) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			
			con.setAutoCommit(false);
			
			PreparedStatement ps = con.prepareStatement(query);
			
			
			for(Book_Order b : blist) {
				
				ps.setString(1, b.getOrderid());
				ps.setString(2, b.getUsername());
				ps.setString(3, b.getEmail());
				ps.setString(4, b.getFullAddress());
				ps.setString(5, b.getPhone());
				ps.setString(6, b.getBookname());
				ps.setString(7, b.getAuthor());
				ps.setString(8, b.getPrice());
				ps.setString(9, b.getPaymentType());
				
				ps.addBatch();
				
			}
			
			
			int[] i = ps.executeBatch();
			
			
			con.commit();
			
			f = true;
			
			con.setAutoCommit(true);
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		return f;
	}















	public List<Book_Order> getBook(String email) {
		
		List<Book_Order> list = new ArrayList<Book_Order>();
		
		Book_Order o = null;
		
		
		try {
			
			String query = "select * from book_order where email = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			
			ps.setString(1, email);
			
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				o = new Book_Order();
				o.setId(rs.getInt(1));
				o.setOrderid(rs.getString(2));
				o.setUsername(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setFullAddress(rs.getString(5));
				o.setPhone(rs.getString(6));
				o.setBookname(rs.getString(7));
				o.setAuthor(rs.getString(8));
				o.setPrice(rs.getString(9));
				o.setPaymentType(rs.getString(10));
				list.add(o);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}















	public List<Book_Order> getAllOrder() {
		
List<Book_Order> list = new ArrayList<Book_Order>();
		
		Book_Order o = null;
		
		
		try {
			
			String query = "select * from book_order";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			
			
			
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				o = new Book_Order();
				o.setId(rs.getInt(1));
				o.setOrderid(rs.getString(2));
				o.setUsername(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setFullAddress(rs.getString(5));
				o.setPhone(rs.getString(6));
				o.setBookname(rs.getString(7));
				o.setAuthor(rs.getString(8));
				o.setPrice(rs.getString(9));
				o.setPaymentType(rs.getString(10));
				list.add(o);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
	
	
	
	
}


























