package com.mfadhili.cheri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Cheri {

	public static void main(String[] args) {
		SpringApplication.run(Cheri.class, args);
		System.out.print("For API documentation check: http://localhost:8081/swagger-ui/");
	}




}
