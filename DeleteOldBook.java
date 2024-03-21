package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.BooksDavImplementation;

@WebServlet("/delete_old_book")
public class DeleteOldBook extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		
		try {
			
			
			
			String email = req.getParameter("em");
			int bookid = Integer.parseInt(req.getParameter("id"));
			
			BooksDavImplementation dao = new BooksDavImplementation(DBConnect.getConnection());
			
			boolean b = dao.oldBookDelete(email, bookid, "Old Book");
			
			
			HttpSession session = req.getSession();
			
			
			if(b) {
				
				session.setAttribute("success", "Old Book Delete Successfully Remove");
				resp.sendRedirect("old_book.jsp");
			}
			else {
				
				session.setAttribute("failed", "Something went wrong");
				resp.sendRedirect("old_book.jsp");
			}
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	
	

}

































