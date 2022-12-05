package com.luiz.financecontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.luiz.financecontrol")
@SpringBootApplication
public class FinancecontrolApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancecontrolApplication.class, args);
	}

}
