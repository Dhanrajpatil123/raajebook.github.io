package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Book_details;
import com.entity.Cart;

public class CartDaoImplementation implements CartDao{

	
	
	private Connection con;
	
	public CartDaoImplementation(Connection con) {
		this.con = con;
	}
	
	
	
	
	public boolean addCart(Cart c) {


		boolean b = false;
		
		
		try {
			
			
			String query = "insert into cart (bid, uid, book_name, author, price, totalprice) values (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, c.getBid());
			ps.setInt(2, c.getUserid());
			ps.setString(3, c.getBookName());
			ps.setString(4, c.getAuthor());
			ps.setDouble(5, c.getPrice());
			ps.setDouble(6, c.getTotalPrice());
			
			
			int i = ps.executeUpdate();
			
			if(i == 1) {
				
				b = true;
			}
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return b;
	}




	public List<Cart> getBookByUser(int userId) {
		
		List<Cart> list = new ArrayList<Cart>();
		
		Cart c = null;
		double totalPrice = 0;
		
		try {
			
			String query = "select * from cart where uid = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
				
				c = new Cart();
				
				c.setCid(rs.getInt(1));
				c.setBid(rs.getInt(2));
				c.setUserid(rs.getInt(3));
				c.setBookName(rs.getString(4));
				c.setAuthor(rs.getString(5));
				c.setPrice(rs.getDouble(6));
				
				totalPrice = totalPrice + rs.getDouble(7);
				c.setTotalPrice(totalPrice);
				
				list.add(c);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}




	public boolean deleteBook(int bid, int uid, int cid) {
		
		
		boolean f = false;
		
		
		try {
			
			String query = "delete from cart where bid = ? and uid = ? and cid = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, bid);
			ps.setInt(2, uid);
			ps.setInt(3, cid);
			
			int i = ps.executeUpdate();
			
			if(i == 1) {
				f = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}

}


































