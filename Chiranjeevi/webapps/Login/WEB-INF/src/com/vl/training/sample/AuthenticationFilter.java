package com.vl.training.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.*;
import javax.servlet.http.*;

public class AuthenticationFilter implements Filter{
    public void init(FilterConfig arg) throws ServletException {
    }
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        PrintWriter out=response.getWriter();
        out.print("filter is invoked before" + request.getParameter("uname") + "\n" + request.getParameter("pass"));
        Cookie cookie = new Cookie(request.getParameter("uname"), request.getParameter("pass"));
        HttpServletResponse res = (HttpServletResponse)response;
        res.addCookie(cookie);
        //out.println(cookie.getName() + "\t" + cookie.getValue());
        chain.doFilter(request, response);//sends request to next resource
        out.print("filter is invoked after");
    }
    public void destroy() {}
}
