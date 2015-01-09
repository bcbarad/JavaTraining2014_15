package com.vl.training.sample;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest.*;
public class LogOut extends HttpServlet {
public void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("Successfully Logged out");
request.getRequestDispatcher("index.html").include(request, response);
}
public void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
doPost(request,response);
}
}
