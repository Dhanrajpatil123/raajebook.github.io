package com.entity;

public class Book_details {
	
	
	private int bookid;
	
	private String bookname;
	
	private String author;
	
	private String price;
	
	private String bookcategory;
	
	private String status;
	
	private String photoname;
	
	private String user_email;
	
	
	
	

	public Book_details() {
		super();
	}





	public Book_details(String bookname, String author,  String price, String bookcategory, String status,
			String photoname, String user_email) {
		super();
		this.bookname = bookname;
		this.author = author;
		this.price = price;
		this.bookcategory = bookcategory;
		this.status = status;
		this.photoname = photoname;
		this.user_email = user_email;
	}





	public int getBookid() {
		return bookid;
	}





	public void setBookid(int bookid) {
		this.bookid = bookid;
	}





	public String getBookname() {
		return bookname;
	}





	public void setBookname(String bookname) {
		this.bookname = bookname;
	}





	public String getAuthor() {
		return author;
	}





	public void setAuthor(String author) {
		this.author = author;
	}





	public  String getPrice() {
		return price;
	}





	public void setPrice( String price) {
		this.price = price;
	}





	public String getBookcategory() {
		return bookcategory;
	}





	public void setBookcategory(String bookcategory) {
		this.bookcategory = bookcategory;
	}





	public String getStatus() {
		return status;
	}





	public void setStatus(String status) {
		this.status = status;
	}





	public String getPhotoname() {
		return photoname;
	}





	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}





	public String getUser_email() {
		return user_email;
	}





	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}





	@Override
	public String toString() {
		return "Book_details [bookid=" + bookid + ", bookname=" + bookname + ", author=" + author + ", price=" + price
				+ ", bookcategory=" + bookcategory + ", status=" + status + ", photoname=" + photoname + ", user_email="
				+ user_email + "]";
	}
	
	
	
	
	
	

}
