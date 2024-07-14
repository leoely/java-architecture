package com.example.kafka1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.example.kafka1.mapper")
@EnableDiscoveryClient
public class Kafka1Application {
	public static void main(String[] args) {
		SpringApplication.run(Kafka1Application.class, args);
	}
}
