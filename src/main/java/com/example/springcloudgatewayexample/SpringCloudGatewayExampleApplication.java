package com.example.springcloudgatewayexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudGatewayExampleApplication{
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayExampleApplication.class, args);
	}
	@Bean
	public KeyResolver testResolver(){
		return exchange -> Mono.just(exchange.getSession().subscribe().toString());
	}
}
