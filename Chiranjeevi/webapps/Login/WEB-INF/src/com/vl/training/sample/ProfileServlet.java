package com.vl.training.sample;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest.*;

public class ProfileServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String docType =
                "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
                "Transitional//EN\">\n";
            Cookie[] ck = request.getCookies();
            if(ck != null) {
                out.print("<center>"+
                       "Welcome " + ck[0].getName() +
                       " and ur Pass " + ck[0].getValue() +
                       "<br/>"
                    );
                out.print("Method" + request.getMethod()+"<br/>");
                out.print("Ur IP is: " + request.getRemoteAddr()+"<br/>");
            }
            else
                response.sendRedirect("/Welcome");
        }
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException {
        doPost(request,response);
    }
}
