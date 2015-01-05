package com.vl.sf.advance;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
		File file = new File(
				"/home/bikash/testprograms/Servlets/WebContent/WEB-INF/properties/logindetails.properties");
		FileInputStream fis = new FileInputStream(file);

		p = new Properties();

		p.load(fis);
		System.out.println("fis: " + fis);
		System.out.println("in filter");
		String user=null;
		String password=null;
		int i=1;
		boolean redirect=false;
		while((user=p.getProperty("user"+i)) != null && (password=p.getProperty("password"+i))!=null){
			if(user.equalsIgnoreCase(request.getParameter("user")) &&  password.equals(request.getParameter("password"))){
				filterChain.doFilter(request, response);
				redirect=true;
			}
			i++;
		}
		if(!redirect){
			response.getWriter().print(" <font color=red>Invalid user and password</font>");
			
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
