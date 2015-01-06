package com.vl.sf.advance;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginCredentialFilter implements Filter {
	Properties p = null;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		
        
		System.out.println("in filter");
		String password = null;
		if ((password = p.getProperty(request.getParameter("user"))) != null
				&& password.equals(request.getParameter("password"))) {
			filterChain.doFilter(request, response);
		} else {
			response.getWriter().print(
					" <font color=red>Invalid user and password</font>");

		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	    try{
	        p = new Properties();
            p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("logindetails.properties"));
	    }catch(FileNotFoundException fne){
	        fne.printStackTrace();
	    }catch(IOException ioe){
	        ioe.printStackTrace();
	    }
	}
}
