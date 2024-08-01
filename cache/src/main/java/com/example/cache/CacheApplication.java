package com.example.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.example.cache.mapper")
@EnableDiscoveryClient
public class CacheApplication {
	public static void main(String[] args) {
		SpringApplication.run(CacheApplication.class, args);
	}
}
