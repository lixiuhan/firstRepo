package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableConfigurationProperties(GreetingsProperties.class)
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

@ConfigurationProperties("greetings")
class GreetingsProperties {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

@RestController
class GreetingsRestController {
	
	private GreetingsProperties gp;

	public GreetingsRestController(GreetingsProperties gp) {
		super();
		this.gp = gp;
	}

	@GetMapping("/hi")
	String hi() {
		return "Hello " + this.gp.getName();
	}
}
