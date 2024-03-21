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
import com.entity.Book_details;


@SuppressWarnings("serial")
@WebServlet("/editbooks")
public class EditBooksServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		try {
			
			int id = Integer.parseInt(req.getParameter("id"));
			
			String bookname = req.getParameter("bname");
			
			String author = req.getParameter("author");
			
			String price = req.getParameter("price");
			
			String status = req.getParameter("bstatus");
			
			
			Book_details b = new Book_details();
			b.setBookid(id);
			b.setBookname(bookname);
			b.setAuthor(author);
			b.setPrice(price);
			b.setStatus(status);
			
			
			BooksDavImplementation dao = new BooksDavImplementation(DBConnect.getConnection());
			
			boolean f = dao.updateEditBooks(b);
			
			HttpSession session = req.getSession();
			
			if (f) {
				
				session.setAttribute("success", "Book Update Successfully");
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









































