package com.codigo.mslogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
//spring.application.name=ms-security
//server.port=0
//eureka.instance.instance-id=${spring.application.name}:${random.uuid}
//spring.jpa.hibernate.ddl-auto=update
//logging.level.root=debug
public class MsLoginApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsLoginApplication.class, args);
	}
}
