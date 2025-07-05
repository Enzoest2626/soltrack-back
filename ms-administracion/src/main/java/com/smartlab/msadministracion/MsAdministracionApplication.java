package com.smartlab.msadministracion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@EnableDiscoveryClient
@EnableFeignClients("com.smartlab.*")
@SpringBootApplication
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class MsAdministracionApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsAdministracionApplication.class, args);
	}
}
