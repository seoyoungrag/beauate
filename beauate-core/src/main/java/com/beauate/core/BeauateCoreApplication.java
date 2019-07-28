package com.beauate.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@SpringBootApplication
@EntityScan(basePackages = {"com.beauate.core.entity"})
@EnableJpaRepositories("com.beauate.core.repository")
public class BeauateCoreApplication {

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.yml,"
            + "/app/config/beauate-core/real-application.yml";
    
	public static void main(String[] args) {
		SpringApplication.run(BeauateCoreApplication.class, args);
	}

}
