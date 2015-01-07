package com.vl.sf.advance;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class URLCheckFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		String schema = request.getScheme();
		System.out.println(schema);
		String serverName = request.getServerName();
		System.out.println(serverName);
		int serverPort = request.getServerPort();
		System.out.println(serverPort);
		String contextPath = ((HttpServletRequest) request).getContextPath();
		String loginPath = schema + "://" + serverName + ":" + serverPort
				+ contextPath;
		System.out.println(loginPath);
		String loginPath1 = loginPath + "/login";
		System.out.println(loginPath1);
		String requestUrl = new String(
				((HttpServletRequest) request).getRequestURL());
		System.out.println(requestUrl);
		RequestDispatcher dispatcher = null;
		if (loginPath.equals(requestUrl) || loginPath1.equals(requestUrl)) {
			System.out.println("Going to login page");
			filterChain.doFilter(request, response);

		} else {
			HttpSession session = ((HttpServletRequest) request)
					.getSession(false);
			String check = null;
			if ((check = (String) session.getAttribute("check")) != null) {
				System.out.println("other than login page");
				System.out.println("Session is exist");
				System.out.println(request.getParameter("user"));
				System.out.println(request.getParameter("password"));
				System.out.println(session);
				if (check.equals((request.getParameter("user") + request
						.getParameter("password")))) {

					dispatcher = request.getRequestDispatcher(requestUrl);
					dispatcher.forward(request, response);

				}
			} else {
				dispatcher = request.getRequestDispatcher("Login.html");
				dispatcher.forward(request, response);
			}
		}

	}

	@Override
	public void destroy() {
	}

}

