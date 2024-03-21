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
@WebServlet("/update_profile")
public class UpdateProfileServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		try {
			
			int id = Integer.parseInt(req.getParameter("id").trim());
			
			String name = req.getParameter("name");
			
			String phone = req.getParameter("phone");
			
			String email = req.getParameter("email");
			
			String password = req.getParameter("password");
			
			HttpSession session = req.getSession();
			
			
			
			
			UserDaoImplementation dao = new UserDaoImplementation(DBConnect.getConnection());
			
			User u = new User();
			
			
			u.setName(name);
			u.setEmail(email);
			u.setPhone(phone);
			u.setId(id);
			
			boolean b = dao.checkPassword(id, password);
			
			
			if(b) {
				
				boolean f = dao.updateProfile(u);
				
				if(f) {
					session.setAttribute("successMsg", "Profile Updated Successfully");
					resp.sendRedirect("edit_profile.jsp");
				}
				else {
					
					session.setAttribute("failedMsg", "Something went wrong...");
					resp.sendRedirect("edit_profile.jsp");
				}
				
			}
			else {
				session.setAttribute("failedMsg", "Your Password Is Incorrect");
				resp.sendRedirect("edit_profile.jsp");
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
