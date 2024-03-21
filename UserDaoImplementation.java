package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;
import com.mysql.cj.protocol.Resultset;

public class UserDaoImplementation implements UserDao{

	
	private Connection con;
	
	
	
	
	
	public UserDaoImplementation(Connection con) {
		super();
		this.con = con;
	}





	public boolean userRegister(User us) {

		boolean f = false;
		
		try {
			
			String query = "insert into user (name, email, phone, password) values (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPhone());
			ps.setString(4, us.getPassword());
			
			
			int i = ps.executeUpdate();
			
			if(i == 1) {
				f = true;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return f;
	}




	
	
	
//	-------------------------------------- Credential method --------------------

	public User login(String email, String password) {


		User us = null;

		
		try {
			
			String query = "select * from user where email = ? and password = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				us = new User();
				
				us.setId(rs.getInt(1));
				us.setName(rs.getString(2));
				us.setEmail(rs.getString(3));
				us.setPhone(rs.getString(4));
				us.setPassword(rs.getString(5));
				us.setAddress(rs.getString(6));
				us.setLandmark(rs.getString(7));
				us.setCity(rs.getString(8));
				us.setState(rs.getString(9));
				us.setPincode(rs.getString(10));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return us;
	}





	public boolean checkPassword(int id, String ps) {
		
		boolean b = false;
		
		
		try {
			
			
			
			String query = "select * from user where id = ? and password = ?";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, id);
			pst.setString(2, ps);
			
			
			ResultSet rs = pst.executeQuery();
			
			
			while(rs.next()) {
				
				b = true;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return b;
	}





	public boolean updateProfile(User us) {
		
		boolean f = false;
		
		try {
			
			String query = "update user set name = ?,  email = ?,  phone = ? where id = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPhone());
			ps.setInt(4, us.getId());
			
			
			int i = ps.executeUpdate();
			
			if(i == 1) {
				f = true;
				System.out.println("done");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return f;
	}





	public boolean checkUser(String email) {
		boolean f = true;

		try {

			String query = "select * from user where email = ?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				f = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}






















