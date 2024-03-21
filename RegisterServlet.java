package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.UserDaoImplementation;
import com.entity.User;



@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String name = req.getParameter("name");
		
		String phone = req.getParameter("phone");
		
		String email = req.getParameter("email");
		
		String password = req.getParameter("password");
		
		String check = req.getParameter("check");
		
		
//		System.out.println(name + " "+ phone+" "+ email+" "+password+" "+check);
		
		
		User us = new User();
		
		
		us.setName(name);
		us.setEmail(email);
		us.setPhone(phone);
		us.setPassword(password);
		
		
		
		HttpSession session = req.getSession();
		
		
		
		if (check!= null) {
			
			UserDaoImplementation dao = new UserDaoImplementation(DBConnect.getConnection());
			
			boolean f2 = dao.checkUser(email);
			
			if(f2) {
				
				boolean f = dao.userRegister(us);
				
				if (f) {
					
//					System.out.println("User register successfully");
					
					session.setAttribute("successMsg", "Registeration successfully");
					resp.sendRedirect("register.jsp");
					
				}
				else {
					
//					System.out.println("something went wrong");
				
					session.setAttribute("failedMsg", "Something went wrong...");
					resp.sendRedirect("register.jsp");
					
				}
				
			}
			else {
				
				session.setAttribute("failedMsg", "user is already exist");
				resp.sendRedirect("register.jsp");
			}
			
		}
		else {
//			System.out.println("please check agree terms....");
			
			session.setAttribute("failedMsg", "Please check Agree Terms & Condition");
			resp.sendRedirect("register.jsp");
			
		}
		
		
		
		
	
		
	}
	
	
	

}


















