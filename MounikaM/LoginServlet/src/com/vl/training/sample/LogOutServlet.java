package com.vl.training.sample;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class LogOutServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        //String url = req.getRequestURL().toString();
        //out.println(url);
        String contextPath = req.getContextPath();
        out.println(contextPath);
        String dob = (String)req.getParameter("dateofbirth");
        out.println("<h4>welcome u enteres dob is </h4>");
        out.println(dob);
        out.println("<form action = \"index.html\" >");
        out.println("<input type = \"submit\" value = \"logout\"/>");
        //RequestDispatcher rd = req.getRequestDispatcher("welcome.html");
       out.close();
    }
}
