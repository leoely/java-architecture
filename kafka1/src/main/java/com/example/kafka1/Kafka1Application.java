package com.example.kafka1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.kafka1.mapper")
public class Kafka1Application {
	public static void main(String[] args) {
		SpringApplication.run(Kafka1Application.class, args);
	}
}
