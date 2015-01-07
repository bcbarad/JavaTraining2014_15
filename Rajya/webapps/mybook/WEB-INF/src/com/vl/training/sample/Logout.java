package com.vl.training.sample;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest.*;

public class Logout extends HttpServlet {
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
                session.invalidate();
                out.println("Successfully Logged out");
                request.getRequestDispatcher("/mybook/Login").include(request, response);
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
