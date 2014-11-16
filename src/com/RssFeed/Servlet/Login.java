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
@WebServlet( urlPatterns = "/login")
public class Login extends HttpServlet 
{
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		if (request.getParameter("logout") != null && request.getParameter("logout").compareTo("1") == 0)
		{
			HttpSession session = request.getSession();
			String token = (String)session.getAttribute("token");
			if (token != null)
			{
				WebService.Logout(token);
				session.removeAttribute("token");
			}
			response.sendRedirect("");
		}
		else
			this.getServletContext().getRequestDispatcher( "/WEB-INF/Login.jsp" ).forward( request, response );
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Confirmation confirmation = WebService.Login(email, password);
		
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
