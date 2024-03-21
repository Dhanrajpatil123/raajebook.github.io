package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.entity.Book_details;

public interface BookDao {

	
	public boolean addBooks(Book_details b);
	
	
	public List<Book_details> getAllBook();
	
	
	public Book_details getBookById(int id);
	
	public boolean updateEditBooks(Book_details b);
	
	public boolean deleteBooks(int id);
	
	public List<Book_details> getNewBook();

	public List<Book_details> getRecentBook();
	
	public List<Book_details> getOldBook();
	
	public List<Book_details> getAllRecentBook();
	
	public List<Book_details> getAllNewBook();
	
	public List<Book_details> getAllOldBook();
	
	public List<Book_details> getBookByOld(String email, String cate);
	
	public boolean oldBookDelete(String email, int bookid,  String cat);
	
	public List<Book_details> getBookBySearch(String character);
	
	
}












































