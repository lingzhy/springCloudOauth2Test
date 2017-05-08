package com.lzy.firstpsringgradle;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication(scanBasePackages = { "com.lzy.firstpsringgradle" })
@RestController
@EnableResourceServer
@EnableTransactionManagement
public class mainClass {
	 public static void main(String[] args) {
	        SpringApplication.run(mainClass.class, args);
	    }
}
