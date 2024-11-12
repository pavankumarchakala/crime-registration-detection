package com.crime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@SpringBootApplication
@RestController
public class CrimeRegistrationDetectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrimeRegistrationDetectionApplication.class, args);
	}

	@GetMapping("/")
	@Operation(hidden = true)
	public String nomapping() {
		return "<h1>Welcome to Crime Registration and Detection App</h1>";
	}
}
