package com.vl.sf.advance;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.print("Hi " + request.getParameter("user"));
		String password = null;
		Properties p = (Properties) getServletContext().getAttribute(
				"propertiesFile");
		if (p != null) {

			if ((password = p.getProperty(request.getParameter("user"))) != null
					&& password.equals(request.getParameter("password"))) {
				HttpSession session = request.getSession();
				session.setAttribute("check", request.getParameter("user")
						+ request.getParameter("password"));
			} else {
				response.getWriter().print(
						" <font color=red>Invalid user and password</font>");

			}
		}
	}

}

