package com.dzsw.wqh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication()
@ComponentScan("com.dzsw.wqh.*")
public class ZcHotelWebApplication extends SpringBootServletInitializer
{

	public static void main(String[] args)
	{
		SpringApplication.run(ZcHotelWebApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application)
	{
		return application.sources(ZcHotelWebApplication.class);
	}
}
