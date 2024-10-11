package com.programming.techie.apigatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ApiGatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayServiceApplication.class, args);
    }
    
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
    	return builder.routes()
    			.route(r -> r.path("/clientes/***").uri("lb://msclientes"))
    			.route(r -> r.path("/cartoes/***").uri("lb://mscartoes"))
    			.build();
    }
}

