package com.beauate.ceo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@SpringBootApplication
@EntityScan(basePackages = {"com.beauate.core.entity"})
@EnableJpaRepositories({"com.beauate.core.repository","com.beauate.ceo.admin"})
public class BeauateCeoApplication {

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.yml,"
            + "/app/config/beauate_ceo/real-application.yml";
    
	public static void main(String[] args) {
		SpringApplication.run(BeauateCeoApplication.class, args);
	}
}
