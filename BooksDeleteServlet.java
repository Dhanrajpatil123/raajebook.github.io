package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.BooksDavImplementation;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class BooksDeleteServlet extends HttpServlet{

	
	// if we directly send request on servlet through anchor tag then by default doget() method will call  // from all_books.jsp
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			
			int id = Integer.parseInt(req.getParameter("id"));
			
			BooksDavImplementation b = new BooksDavImplementation(DBConnect.getConnection());
			
			boolean f = b.deleteBooks(id);
			
			System.out.println(f);
		
			
			HttpSession session = req.getSession();
			
			if (f) {
				
				session.setAttribute("success", "Book Deleted Successfully");
				resp.sendRedirect("admin/all_books.jsp");
			}
			else {
				session.setAttribute("failmsg", "Something went wrong");
				resp.sendRedirect("admin/all_books.jsp");
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	

	
	
}
