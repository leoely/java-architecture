package com.example.location;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.example.location.mapper")
@EnableDiscoveryClient
public class LocationApplication {
	public static void main(String[] args) {
		SpringApplication.run(LocationApplication.class, args);
	}
}
