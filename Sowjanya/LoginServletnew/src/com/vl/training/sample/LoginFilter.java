package com.vl.training.sample;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.*;

public class LoginFilter implements Filter {
    public void init(FilterConfig arg) throws ServletException {
    }
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException , ServletException {
        PrintWriter out = res.getWriter();
       res.setContentType("text/html");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;       
        HttpSession session = request.getSession();
        out.print("filter started.............");    
        if(session!=null) {  
           chain.doFilter(request, response);
        } else {          
           out.println("you are new user:");    
           RequestDispatcher rd=request.getRequestDispatcher("index.html");  
           rd.include(request, response);
        } 
        session.invalidate();
        out.print("filter ended.............");    
    }
    public void destroy() {
    }
}

