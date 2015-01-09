package com.vl.training.sample;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest.*;

public class Profile extends HttpServlet {
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String docType =
                "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
                "Transitional//EN\">\n";
            //Display the user profile using session attributes
            HttpSession session = request.getSession(false);
            if(session != null) {
                out.print("<center>"+
                        "Welcome " + session.getAttribute("uname") +
                        " and ur Session Id: " + session.getId() +
                        "<br/>" +
                        "<a href=/mybook/Logout>Logout</a>"
                        );
                out.print("Method" + request.getMethod()+"<br/>");
                out.print("Ur IP is: " + request.getRemoteAddr()+"<br/>");
            }
            else {
                response.sendRedirect("/mybook/Login");
            }
        }
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException {
            doPost(request,response);
        }
}
