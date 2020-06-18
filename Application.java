package com.javainuse;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableResourceServer
@SpringBootApplication
public class Application {
	public static void main(String args[]) {
		//SpringApplication.run(Application.class, args);
		System.out.println("IN Auth Server main()");
		SpringApplication app = new SpringApplication(Application.class);
		Map<String, Object> appProperties = new HashMap<String, Object>();
    	appProperties.put("server.port", "9090");
    	
    	app.setDefaultProperties(appProperties);
    	
    	app.run(args);
	}

	@RequestMapping("/validateUser")
	public Principal user(Principal user) {
		return user;
		
	}
	
	@Configuration
	protected static class AuthenticationManagerConfiguration extends GlobalAuthenticationConfigurerAdapter {
		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("javainuse-user").password("javainuse-pass").roles("USER");
		}
	}
}
