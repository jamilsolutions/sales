package com.crm.sales;

import com.crm.sales.config.ApiConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import(ApiConfig.class)
public class ApiSalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSalesApplication.class, args);
	}

}
