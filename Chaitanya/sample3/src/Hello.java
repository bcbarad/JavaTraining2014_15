//package com.vl.training;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Enumeration;
import java.util.*;
import javax.servlet.RequestDispatcher;
public class Hello extends HttpServlet implements Filter {
    private ArrayList<String> urlList;
    public void init(FilterConfig fc) throws ServletException { 
        urlList = new ArrayList<String>();
    }
    public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain) throws IOException,ServletException {
        PrintWriter out = res.getWriter();
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
      /*   //String url = request.getServletPath();
        boolean isalreadyuser = false;
        HttpSession hs;
       if (urlList.contains(url)) {
             isalreadyuser = true;
out.println("Filter array");
             chain.doFilter(req,res);
        }
out.println(isalreadyuser);
        if (!(isalreadyuser)) {
out.println("not isalreadyuser");
            hs = request.getSession(true);
out.println("session created");
            urlList.add(url);
out.println("url added");
            if ( hs != null) {
out.println("inside session");
                RequestDispatcher rd = req.getRequestDispatcher("hello.html");
                rd.forward(req, res);
            }
//out.println("outside"+hs);
            //isalreadyuser = true;
        }*/
        
        HttpSession hs = request.getSession(true);
        if (!hs.isNew()) {
            out.println("Filter Started");
            chain.doFilter(req,res);
           out.println("Filter endeded");
        }
        else {
            RequestDispatcher rd=req.getRequestDispatcher("hello.html");
            rd.include(req, res);
        }
    }
    public void destroy() {
    }
}
