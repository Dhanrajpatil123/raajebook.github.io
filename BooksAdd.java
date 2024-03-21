package com.admin.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DB.DBConnect;
import com.dao.BooksDavImplementation;
import com.entity.Book_details;




@SuppressWarnings("serial")
@WebServlet("/addbooks")
@MultipartConfig
public class BooksAdd extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		
		try {
			
			String bookname = req.getParameter("bname");
			
			String author = req.getParameter("author");
			
//			double price = Double.parseDouble(req.getParameter("price"));
			String price = req.getParameter("price");
			
			String bookcategory = req.getParameter("btype");
			
			String status = req.getParameter("bstatus");
			
			Part part = req.getPart("bimg");
			
			String filename = part.getSubmittedFileName();
			
			
			
			Book_details b = new Book_details(bookname, author, price, bookcategory ,status, filename, "admin");
			


			BooksDavImplementation dao = new BooksDavImplementation(DBConnect.getConnection());
			
			
			
			  
			  
			
			  boolean f = dao.addBooks(b);
			  
			  HttpSession session = req.getSession();
			  
			  if(f) {
			  
			  
				  String path = getServletContext().getRealPath("")+"book";

				//System.out.println(path);
							  File file = new File(path);
							  
							  part.write(path + File.separator + filename);
			  
			  session.setAttribute("success", "Book Added Successfully");
			  resp.sendRedirect("admin/add_book.jsp");
			  
			  } 
			  else { session.setAttribute("failmsg", "Something went wrong...");
			  resp.sendRedirect("admin/add_book.jsp");
			  
			  }
			 
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	

}







































