package com.tapfoods.CONTROLLER;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tapfoods.DAO.UserDAO;
import com.tapfoods.DAOImpl.UserDAOImpl;
import com.tapfoods.models.User;

@SuppressWarnings("serial")
@WebServlet("/sendData")
public class RegistrationServlet extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("fullname");
		String email=req.getParameter("email");
		String phonenumber=req.getParameter("phonenumber");
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		
		User u=new User(username, email, phonenumber, password, address);
		System.out.println(u.toString());
		UserDAO userDAO =new  UserDAOImpl();
		int x=userDAO.addUser(u);
		System.out.println(x);
		if(x==1)
		{
			resp.sendRedirect("registrationSuccess.jsp");
		}
		else
		{
			resp.sendRedirect("registrationFailure.jsp");
		}
	}
}
