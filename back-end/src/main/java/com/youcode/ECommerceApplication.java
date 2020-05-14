package com.youcode;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.youcode.config.FileStorageProperties;


@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

}
