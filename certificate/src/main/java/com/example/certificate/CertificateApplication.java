package com.example.certificate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.example.certificate.mapper")
@EnableDiscoveryClient
public class CertificateApplication {
	public static void main(String[] args) {
		SpringApplication.run(CertificateApplication.class, args);
	}
}
