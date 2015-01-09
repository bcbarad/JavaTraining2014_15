package com.vl.training.sample;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet{
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String docType =
                "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
                "Transitional//EN\">\n";
            if(request.getParameter("status") != null){
                out.print("Error: " + request.getParameter("status") + "<br/>");
            }
            out.print("<center><form action = /mybook/authenticate method=post>" +
                    "<input type = text name= uname placeholder= User Name />" +
                    "<br/><input type = password name= pass placeholder = Password />" +
                    "<br/><input type = submit value = Login />" +
                    "<input type = reset value = Reset />" +
                    "</form><br/>"
                    );
            out.print("Method" + request.getMethod()+"<br/>");
            out.print("Ur IP is: " + request.getRemoteAddr()+"<br/>");
        }

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException {
            doPost(request,response);
        }

}
