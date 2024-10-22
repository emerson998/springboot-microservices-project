package com.programming.techie;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class MsCartoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCartoesApplication.class, args);
	}

}
