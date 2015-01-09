//package com.vl.training;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;   
public class Profile extends HttpServlet {  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");         
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<body>");
        out.print("<h4> logged in sucessfully</h4>");
        out.print("<form action=\"Logout\" method=\"post\">");
        out.print("Date of birth:<input type=\"date\" name=\"dob\" max=\"2015-01-01\">");
        out.print("<input type=\"submit\" name=\"submit\" value=\"Submit\">");
        out.print("</form>");
        out.print("</body>");
        out.print("</html>");
    }  
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
doPost(request, response);
}  
}
