package com.vl.sf.advance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
	Properties p = null;

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		p.clear();
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		try{
	        p = new Properties();
            p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("logindetails.properties"));
	    }catch(FileNotFoundException fne){
	        fne.printStackTrace();
	    }catch(IOException ioe){
	        ioe.printStackTrace();
	    }
		servletContextEvent.getServletContext().setAttribute("propertiesFile",
				p);
		System.out.println("Properties file is loaded into the context object");
	}

}

