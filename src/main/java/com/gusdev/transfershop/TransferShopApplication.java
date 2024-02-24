package com.gusdev.transfershop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TransferShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransferShopApplication.class, args);
	}

}
