package com.vl.utms.grabber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;


public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GrabApplication.class);
	}
	
	public static void main(String[] args) {
        SpringApplication.run(ServletInitializer.class, args);
    }

}
