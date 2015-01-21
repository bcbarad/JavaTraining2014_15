//package com.vl.training;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;   
public class Logout extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");      
        PrintWriter out = response.getWriter();
        out.print(" <h1>Welcome to you account </h1> ");
        out.print("<form action=\"hello.html\" method = \"POST\" >");
        out.print("<input type=\"submit\" name=\"Logout\" value=\" Logout\">");
        out.print("</form>");
    }  
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
doPost(request, response);
}
}  
