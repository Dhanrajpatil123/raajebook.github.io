package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.CartDaoImplementation;

@SuppressWarnings("serial")
@WebServlet("/remove_book")
public class RemoveBookCart extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int bid = Integer.parseInt(req.getParameter("bid"));
		int uid = Integer.parseInt(req.getParameter("uid"));
		int cid = Integer.parseInt(req.getParameter("cid"));
		
		CartDaoImplementation dao = new CartDaoImplementation(DBConnect.getConnection());
		
		boolean b = dao.deleteBook(bid, uid, cid);
		
		
		HttpSession session = req.getSession();
		
		
		if(b) {
			
			session.setAttribute("success", "Book Successfully Remove");
			resp.sendRedirect("checkout.jsp");
		}
		else {
			
			session.setAttribute("failed", "Something went wrong");
			resp.sendRedirect("checkout.jsp");
		}
		
		
		
	}

	
	
	
}



















