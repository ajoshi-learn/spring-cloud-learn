package edu.arturjoshi.discoveryclientsecond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DiscoveryClientSecondApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryClientSecondApplication.class, args);
	}
}
