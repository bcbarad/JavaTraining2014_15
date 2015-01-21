package com.vl.training.sample;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class LoginServlet extends HttpServlet {
    Properties p = null;
    public void init() {
        p = new Properties();
        try {
        p.load(getServletContext().getResourceAsStream("WEB-INF/resources/sample.properties"));
        }catch(IOException io) {
        System.err.println("Exception"+io);
        }
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        boolean flag = false;

        String user = req.getParameter("username");
        String pwd = req.getParameter("password");

        Enumeration enumVal = p.keys();
        String url = req.getRequestURL().toString();
        out.println(url);

        while(enumVal.hasMoreElements()) {
            String name = (String) enumVal.nextElement();
            String value = p.getProperty(name);

            if (user.equals(name) && pwd.equals(value)) {
                flag = true;
                break;
            }
        }
        if(flag) {
            HttpSession session = req.getSession(true);
            session.setAttribute("username", user);
            RequestDispatcher rd = req.getRequestDispatcher("UserInfoServlet");
            rd.forward(req,res);
        }
        else {
            out.println("please login");
            RequestDispatcher rd = req.getRequestDispatcher("index.html");
            rd.include(req,res);
        }
        out.close();
    }
}




