package com.vl.training.sample;

import java.util.Enumeration;
import java.util.Properties;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class AuthenticationServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            String uname = request.getParameter("uname");
            String password = request.getParameter("pass");
            boolean flag = false;
            //Loading properties file
            Properties properties = new Properties();
            properties.load(getServletContext().getResourceAsStream("/WEB-INF/classes/user.properties"));
            String value = properties.getProperty(uname);
            if(value != null) {
                if (value.equals(password)) {
                    flag = true;
                }
            } else {
                out.println("<font color=red><center>Username is Invalid.</font>");
                request.getRequestDispatcher("/Login").include(request, response);
                return;
            }
            if(flag) {
                //Authentic user
                HttpSession session = request.getSession();
                session.setAttribute("uname", uname);
                response.sendRedirect("/mybook/Profile");
            } else {
                //Invalid User
                out.println("<font color=red><center>Password is wrong.</font>");
                request.getRequestDispatcher("/Login").include(request, response);
            }
        }

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException {
            doPost(request, response);
        }
}
