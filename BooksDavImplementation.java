package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Book_details;

public class BooksDavImplementation implements BookDao{
	
	
	private Connection con;
	
	
	

	public BooksDavImplementation(Connection con) {
		super();
		this.con = con;
	}




	public boolean addBooks(Book_details b) {
		
		boolean f = false;
		
		
		try {
			
			
			String query = "insert into book_details (bookname, author, price, bookcategory, status, photo, useremail) values (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, b.getBookname());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getPrice());
			ps.setString(4, b.getBookcategory());
			ps.setString(5, b.getStatus());
			ps.setString(6, b.getPhotoname());
			ps.setString(7, b.getUser_email());
			
			
			int i = ps.executeUpdate();
			
			
			
			if(i == 1) {
				
				f = true;
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return f;
	}




	
	
	
	
	
	
	
//-----------------------------------------------------------------------------------
	
	public List<Book_details> getAllBook() {
		
		
		List<Book_details> list = new ArrayList<Book_details>();
		
		Book_details b = null;
		
		
		try {
			
			
			String query = "select * from book_details";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
				b = new Book_details();
				
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookcategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setUser_email(rs.getString(8));
				
				list.add(b);
			}
			
			
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return list;
	}


	
	
	
	
//	------------------------------------------------------------------------------------------------
	


	public Book_details getBookById(int id) {
		
		
		
		Book_details b = null;
		
		
		
		try {
			
			
			String query = "select * from book_details where bookid = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
				b = new Book_details();
				
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookcategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setUser_email(rs.getString(8));
				
				
			}
				
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	
		return b;
	}




	public boolean updateEditBooks(Book_details b) {


		boolean f = false;
		
		
		try {
			
			String query = "update book_details set bookname = ?, author = ?, price = ?, status = ? where bookid = ?";
			
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, b.getBookname());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getPrice());
			ps.setString(4, b.getStatus());
			ps.setInt(5, b.getBookid());
			
			int i = ps.executeUpdate();
			
			if(i == 1) {
				
				f = true;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}




	public boolean deleteBooks(int id) {
	
		boolean f = false;
		
		
		try {
		
			
			String query = "delete from book_details where bookid = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			
			if(i == 1) {
				f = true;
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}




	public List<Book_details> getNewBook() {

		List<Book_details> list = new ArrayList<Book_details>();
		
		Book_details b = null;
		
		
		
		try {
			
			String query = "select * from book_details where bookcategory = ? and status = ? order by bookid DESC";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, "New Book");
			ps.setString(2, "Active");
			
			ResultSet rs = ps.executeQuery();
			
			int i = 1;
			
			while(rs.next() && i <= 4) {
				
				b = new Book_details();
				
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookcategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setUser_email(rs.getString(8));
				
				list.add(b);
				i++;
			}
			
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		

		return list;
	}



	

	public List<Book_details> getRecentBook() {


		List<Book_details> list = new ArrayList<Book_details>();
		
		Book_details b = null;
		
		
		
		try {
			
			String query = "select * from book_details where status = ? order by bookid DESC";
			
			PreparedStatement ps = con.prepareStatement(query);
			
//			ps.setString(1, "New Book");
			ps.setString(1, "Active");
			
			ResultSet rs = ps.executeQuery();
			
			int i = 1;
			
			while(rs.next() && i <= 4) {
				
				b = new Book_details();
				
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookcategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setUser_email(rs.getString(8));
				
				list.add(b);
				i++;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}




	public List<Book_details> getOldBook() {
List<Book_details> list = new ArrayList<Book_details>();
		
		Book_details b = null;
		
		
		
		try {
			
			String query = "select * from book_details where bookcategory = ? and status = ? order by bookid DESC";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, "Old Book");
			ps.setString(2, "Active");
			
			ResultSet rs = ps.executeQuery();
			
//			int i = 1;
			
			while(rs.next()) {
				
				b = new Book_details();
				
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookcategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setUser_email(rs.getString(8));
				
				list.add(b);
//				i++;
			}
			
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		

		return list;
	}




	public List<Book_details> getAllRecentBook() {


		List<Book_details> list = new ArrayList<Book_details>();
		
		Book_details b = null;
		
		
		
		try {
			
			String query = "select * from book_details where status = ? order by bookid DESC";
			
			PreparedStatement ps = con.prepareStatement(query);
			
//			ps.setString(1, "New Book");
			ps.setString(1, "Active");
			
			ResultSet rs = ps.executeQuery();
			
//			int i = 1;
			
			while(rs.next()) {
				
				b = new Book_details();
				
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookcategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setUser_email(rs.getString(8));
				
				list.add(b);
//				i++;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}




	public List<Book_details> getAllNewBook() {
		
		

		List<Book_details> list = new ArrayList<Book_details>();
				
				Book_details b = null;
				
				
				
				try {
					
					String query = "select * from book_details where bookcategory = ? and status = ? order by bookid DESC";
					
					PreparedStatement ps = con.prepareStatement(query);
					
					ps.setString(1, "New Book");
					ps.setString(2, "Active");
					
					ResultSet rs = ps.executeQuery();
					
//					int i = 1;
					
					while(rs.next()) {
						
						b = new Book_details();
						
						b.setBookid(rs.getInt(1));
						b.setBookname(rs.getString(2));
						b.setAuthor(rs.getString(3));
						b.setPrice(rs.getString(4));
						b.setBookcategory(rs.getString(5));
						b.setStatus(rs.getString(6));
						b.setPhotoname(rs.getString(7));
						b.setUser_email(rs.getString(8));
						
						list.add(b);
//						i++;
					}
					
					
					
				} catch (Exception e) {

					e.printStackTrace();
				}
				
				
				

				return list;
	}




	public List<Book_details> getAllOldBook() {
		
		
List<Book_details> list = new ArrayList<Book_details>();
		
		Book_details b = null;
		
		
		
		try {
			
			String query = "select * from book_details where bookcategory = ? and status = ? order by bookid DESC";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, "Old Book");
			ps.setString(2, "Active");
			
			ResultSet rs = ps.executeQuery();
			
			int i = 1;
			
			while(rs.next() && i <= 4) {
				
				b = new Book_details();
				
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookcategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setUser_email(rs.getString(8));
				
				list.add(b);
				i++;
			}
			
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		

		return list;
	}




	public List<Book_details> getBookByOld(String email, String cate) {
		
		
		List<Book_details> list = new ArrayList<Book_details>();
		
		
		
		Book_details b = null;
		
		
		try {
			
			
			String query = "select * from book_details where bookcategory = ? and useremail = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			

			ps.setString(1, cate);
			ps.setString(2, email);
			
			
			ResultSet rs = ps.executeQuery();
			
		
			while(rs.next()) {
				
				b = new Book_details();
				
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookcategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setUser_email(rs.getString(8));
				
				list.add(b);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}




	public boolean oldBookDelete(String email, int bookdid, String cat) {
		
		
		boolean f = false;
		
		
		try {
			
			
			String query = "delete from book_details where bookcategory = ? and useremail = ? and bookid = ?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, cat);
			ps.setString(2, email);
			ps.setInt(3, bookdid);
			
			
			int i = ps.executeUpdate();
			
			if(i == 1) {
				f = true;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return f;
	}




	public List<Book_details> getBookBySearch(String character) {
		
List<Book_details> list = new ArrayList<Book_details>();
		
		
		
		Book_details b = null;
		
		
		try {
			
			
			String query = "select * from book_details where bookname like ? or author like ? or bookcategory like ? and status = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			

			ps.setString(1, "%"+character+"%");
			ps.setString(2, "%"+character+"%");
			ps.setString(3, "%"+character+"%");
			ps.setString(4, "Active");
			
			
			
			ResultSet rs = ps.executeQuery();
			
		
			while(rs.next()) {
				
				b = new Book_details();
				
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookcategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setUser_email(rs.getString(8));
				
				list.add(b);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}




	
	
	
	
	
	
	
	
	
	
	
	

	
	

}






























