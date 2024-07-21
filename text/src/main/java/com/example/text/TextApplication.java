package com.example.text;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TextApplication {
	public static void main(String[] args) {
		SpringApplication.run(TextApplication.class, args);
	}
}
