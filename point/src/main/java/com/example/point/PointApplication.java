package com.example.point;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.example.point.mapper")
public class PointApplication {
	public static void main(String[] args) {
		SpringApplication.run(PointApplication.class, args);
	}
}
