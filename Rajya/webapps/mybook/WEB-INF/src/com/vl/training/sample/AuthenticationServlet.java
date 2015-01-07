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
            //Get values using session
            String uname = request.getParameter("uname");
            String password = request.getParameter("pass");
            boolean flag = false;
            Properties properties = new Properties();
            properties.load(getServletContext().getResourceAsStream("/WEB-INF/classes/user.properties"));
            Enumeration enuKeys = properties.keys();
            while (enuKeys.hasMoreElements()) {
                String key = (String) enuKeys.nextElement();
                String value = properties.getProperty(key);
                if ( key.equals(uname) && value.equals(password)){
                    flag = true;
                    break;
                }
            }
            if(flag){
                //Authentic user
                HttpSession session = request.getSession();
                session.setAttribute("uname", uname);
                response.sendRedirect("/mybook/Profile");
            } else {
                //Invalid User
                out.println("<font color=red>Either user name or password is wrong.</font>");
                request.getRequestDispatcher("/Login").include(request, response);
            }
        }

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException {
            doPost(request, response);
        }
}
