package com.vl.training.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.*;

public class LoginFilter implements Filter{

    public void init(FilterConfig arg) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        PrintWriter out=response.getWriter();
        HttpSession session = ((HttpServletRequest)request).getSession(false);
        HttpServletResponse res = (HttpServletResponse) response;
        if(session != null){
            res.sendRedirect("/mybook/Profile");
        }
        out.print("filter is invoked after");
        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}

