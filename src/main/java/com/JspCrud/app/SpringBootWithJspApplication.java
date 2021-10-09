package com.JspCrud.app;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
 
 
@SpringBootApplication(scanBasePackages = "com.JspCrud.app")
public class SpringBootWithJspApplication extends SpringBootServletInitializer {
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootWithJspApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithJspApplication.class, args);
	}
	
	 

}
