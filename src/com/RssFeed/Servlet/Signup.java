package com.RssFeed.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.RssFeed.WebService;
import com.RssFeed.Bean.Confirmation;

@SuppressWarnings("serial")
@WebServlet( urlPatterns = "/signup" )
public class Signup extends HttpServlet 
{
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		this.getServletContext().getRequestDispatcher( "/WEB-INF/Signup.jsp" ).forward( request, response );
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		Confirmation confirmation = WebService.SignUp(email, password, firstName, lastName);
		
	    if (confirmation.getConfirmation())
	    {
		    session.setAttribute("token", confirmation.getMessage());
		    response.sendRedirect("");
	    }
	    else
    	{
	    	request.setAttribute( "errorMessage", confirmation.getMessage());
    		this.getServletContext().getRequestDispatcher( "/WEB-INF/Login.jsp" ).forward( request, response );
    	}
	}
}