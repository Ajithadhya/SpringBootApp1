package com.example;


import org.springframework.boot.builder.SpringApplicationBuilder;


public class ServletInitializer extends org.springframework.boot.web.servlet.support.SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CurrencyExchangeServiceApplication.class);
	}

}