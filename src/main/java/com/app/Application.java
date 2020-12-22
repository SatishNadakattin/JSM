package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableScheduling
@EnableWebSecurity
@EnableEncryptableProperties
public class Application extends SpringBootServletInitializer {	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder app) {
        return app.sources(Application.class);
    }	
	
	
	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/Janasamruddhi");    
		 SpringApplication.run(Application.class, args);	
		// PropertyConfigurator.configure("log4j.properties");
	}
}