package com.vl.training.sample;

import java.util.Enumeration;
import java.util.Properties;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class AuthenticatorServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            out.println("Log1:");
                Cookie[] ck = request.getCookies();
                String uname = ck[0].getName();
                String pwd = ck[0].getValue();
                out.println(uname + pwd);
                out.println(uname + " " + pwd);
                boolean flag = false;
                Properties properties = new Properties();
                properties.load(getServletContext().getResourceAsStream("/WEB-INF/classes/user.properties"));
                Enumeration enuKeys = properties.keys();
                while (enuKeys.hasMoreElements()) {
                    String key = (String) enuKeys.nextElement();
                    String value = properties.getProperty(key);
                    if ( key.equals(uname) && value.equals(pwd)){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    //Authentic user
                    response.sendRedirect("/Profile");
                } else {
                    //Invalid User
                    out.println("User details are invalid");
                    ck[0].setMaxAge(0);
                    response.sendRedirect("/Welcome");
                    out.println("<font color=red>Either user name or password is wrong.</font>");
                }
        }

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException {
            doPost(request, response);
        }
}
