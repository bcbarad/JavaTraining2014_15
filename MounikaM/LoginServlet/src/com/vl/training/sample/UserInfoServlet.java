package com.vl.training.sample;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UserInfoServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        HttpSession session = req.getSession(false);
        String name = (String) session.getAttribute("username");

        out.println("hello" + name);
        out.println("<html><body><form action= \"LogOutServlet\" method=\"get\">");
        out.println("date of birth : <input type=\"text\" name=\"dateofbirth\">");
        out.println("<input type=\"submit\" value=\"submit\">");
        out.println("</form></body></html>");
        out.close();
    }
}
