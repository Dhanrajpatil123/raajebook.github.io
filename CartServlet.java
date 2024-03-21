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
import com.dao.CartDaoImplementation;
import com.entity.Book_details;
import com.entity.Cart;


@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			int bid = Integer.parseInt(req.getParameter("bid"));
			int uid = Integer.parseInt(req.getParameter("uid"));
//			String bookname = req.getParameter("");
//			String author = req.getParameter("");
			
			
			BooksDavImplementation dao = new BooksDavImplementation(DBConnect.getConnection());
			
			Book_details b = dao.getBookById(bid);
			
			
			Cart c = new Cart();
			c.setBid(bid);
			c.setUserid(uid);
			c.setBookName(b.getBookname());
			c.setAuthor(b.getAuthor());
			c.setPrice(Double.parseDouble(b.getPrice()));
			c.setTotalPrice(Double.parseDouble(b.getPrice()));
			
			
			CartDaoImplementation dao2 = new CartDaoImplementation(DBConnect.getConnection());
			
			boolean f = dao2.addCart(c);
			
			HttpSession session = req.getSession();
		
			
			if(f) {
				
				session.setAttribute("addcart", "Book Added To Cart");
				resp.sendRedirect("all_new_book.jsp");
				
			}
			else {

				session.setAttribute("failed", "Something went wrong");
				resp.sendRedirect("all_new_book.jsp");
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	
}





















