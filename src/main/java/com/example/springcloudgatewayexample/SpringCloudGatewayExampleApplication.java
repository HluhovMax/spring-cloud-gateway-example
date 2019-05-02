package com.example.springcloudgatewayexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@EnableDiscoveryClient
@SpringBootApplication
// @EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringCloudGatewayExampleApplication /** extends WebSecurityConfigurerAdapter */{
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayExampleApplication.class, args);
	}
/**
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Disable CSRF (cross site request forgery)
		http.cors().and().csrf().disable();

		// No session will be created or used by spring security
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Entry points
		http.authorizeRequests()

				// Disallow everything else..
				.anyRequest().authenticated();
		// http.apply();
		http.httpBasic();
	}
 */

	@Bean
	public KeyResolver testResolver(){
		return exchange -> Mono.just(exchange.getSession().subscribe().toString());
	}
}
