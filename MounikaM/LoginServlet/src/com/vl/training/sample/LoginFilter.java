package com.vl.training.sample;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.*;

public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        PrintWriter out = res.getWriter();


        HttpSession session = request.getSession(true);
        out.println(session);
        if (session.isNew()) {
             RequestDispatcher rd = req.getRequestDispatcher("index.html");
             rd.forward(req,res);
            //response.sendRedirect("/LoginServlet/UserInfoServlet");
        }
        else {
             out.println("filter before invoked");
            chain.doFilter(req,res);
            out.println("filter ended");
        }
    }
    public void destroy() {
    }
}


