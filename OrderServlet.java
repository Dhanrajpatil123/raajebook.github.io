package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.BookOrderImplementation;
import com.dao.CartDaoImplementation;
import com.entity.Book_Order;
import com.entity.Cart;

@WebServlet("/order")
@SuppressWarnings("serial")
public class OrderServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		
		try {
			
			
			HttpSession session = req.getSession();
			
			
			
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("username");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			String landmark = req.getParameter("landmark");
			String city = req.getParameter("city");
			String state = req.getParameter("state");
			String pincode = req.getParameter("pincode");
			String payment = req.getParameter("payment");
			
			
			String fullAddress = address +", " + landmark + ", " + city + ", " + state + ", " +pincode;
			
			
//			System.out.println(name + " "+ email +" "+ phone + " "+ fullAddress +" "+ payment);
			
			
			CartDaoImplementation dao = new CartDaoImplementation(DBConnect.getConnection());
			
			List<Cart> blist = dao.getBookByUser(id);
			
			
			
			if(blist.isEmpty()) {
				
				session.setAttribute("failed", "Please Add Items");
				resp.sendRedirect("checkout.jsp");
				
				
			}
			else {
				
				
				BookOrderImplementation dao2 = new BookOrderImplementation(DBConnect.getConnection());
				
				
				
				
				Book_Order o = null;
				
				
				
				Random r = new Random();
				
				
				
				ArrayList<Book_Order> ordlist = new ArrayList<Book_Order>();
				
				
				for(Cart c : blist) {
					
					o = new Book_Order();
					
					o.setOrderid("Book-ORD--00 "+ r.nextInt(1000));
					o.setUsername(name);
					o.setEmail(email);
					o.setPhone(phone);
					o.setFullAddress(fullAddress);
					o.setBookname(c.getBookName());
					o.setAuthor(o.getAuthor());
					o.setPrice(c.getPrice()+ "");
					o.setPaymentType(payment);
					
					ordlist.add(o);
					
					
				}
				
				
				
				if("noselect".equals(payment)) {
					
					session.setAttribute("failed", "Please Choose Payment Method");
					
					resp.sendRedirect("checkout.jsp");
				}
				else {
					
					
					boolean b = dao2.saveOrder(ordlist);
					
					
					if(b) {
						
						resp.sendRedirect("order_success.jsp");
//						System.out.println("order done");
					}
					else {
						
						session.setAttribute("failed", "Order Failed...");
						
						resp.sendRedirect("checkout.jsp");
//						System.out.println("wrong");
					}
					
				}
				
				
				
				
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	

}














