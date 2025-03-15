package com.tapfoods.CONTROLLER;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.DAO.UserDAO;
import com.tapfoods.DAOImpl.UserDAOImpl;
import com.tapfoods.models.User;


@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet 
{
       private HttpSession session;

	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
		
		//int email=(Integer.parseInt(req.getParameter("email")));
		
		String email=req.getParameter("email");
    	String password=req.getParameter("password");  
    	
    	 UserDAO userDAO =new  UserDAOImpl();
    	
    	 User user=userDAO.getUser(email);
    	 
    	 
    	 
    	 session=req.getSession();
    
    	 
    	 //System.out.println(user);
    	   if(user!=null&&password.equals(user.getPassword()))
    	   {
    		   
     
    		   session.setAttribute("session_user", user);
    		   
    		   resp.sendRedirect("RestaurantServlet");
    	   }
    	   else
    	   {
    		   resp.sendRedirect("registration.jsp");
    	   }
    }
    
}
