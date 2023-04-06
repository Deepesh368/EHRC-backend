package com.example.hosptial_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
@SpringBootApplication
public class HosptialServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(HosptialServiceApplication.class,args);
	}

	private static void startInstance( String configFile,String [] args) {
		// Create a Spring application context with the specified configuration file
		ConfigurableApplicationContext context = new SpringApplicationBuilder(HosptialServiceApplication.class)
				.properties("spring.config.location=" + configFile)
				.run();

		// Configure the embedded web server to listen on the specified port
		ConfigurableWebServerFactory serverFactory = context.getBean(ConfigurableWebServerFactory.class);
		//serverFactory.setPort(port);

		// Connect to the database using the provided configuration properties
		DataSource dataSource = context.getBean(DataSource.class);

		// Run the Spring Boot application with the embedded web server and database connection
		SpringApplication.run(HosptialServiceApplication.class,args);
	}
	@Bean
	public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
		return new TomcatServletWebServerFactory();
	}

}
