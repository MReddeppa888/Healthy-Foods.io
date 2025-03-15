package com.tapfoods.CONTROLLER;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tapfoods.DAOImpl.UserDAOImpl;
import com.tapfoods.models.User;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String phonenumber=req.getParameter("phonenumber");
		String address=req.getParameter("address");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		
		User u = new User(name, email, phonenumber, password, address);
		
		UserDAOImpl userDAO = new UserDAOImpl();
		
		int x = userDAO.updateUser(u);
		
		if(x==1)
		{
			resp.sendRedirect("updateSuccess.jsp");
		}
		else
		{
			resp.sendRedirect("updateFailure.jsp");
		}
	}
}
