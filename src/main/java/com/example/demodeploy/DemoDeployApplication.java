package com.example.demodeploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoDeployApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDeployApplication.class, args);
	}

	@GetMapping("/")
	public String home(){
		return "Welcome Home test0";
	}

}
