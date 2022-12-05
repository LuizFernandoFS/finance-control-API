package com.luiz.financecontrol.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.luiz.financecontrol.service.DBService;

@Configuration
@Profile(value = "test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	void iniciaBaseDeDados() {
		this.dbService.iniciaBaseDeDados();
	}
}