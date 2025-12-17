package com.pinkitec;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableRabbit
@EnableWebMvc
@EnableFeignClients
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 10800, redisFlushMode = RedisFlushMode.IMMEDIATE)
@ServletComponentScan
@EnableScheduling
public class ApsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApsApplication.class, args);
	}
	
}
