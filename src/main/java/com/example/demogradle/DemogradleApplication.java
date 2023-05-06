package com.example.demogradle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@MapperScan("com.example.demogradle.mapper")
public class DemogradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemogradleApplication.class, args);
		System.out.println("springboot启动成功");
	}

}
