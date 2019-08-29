package com.works.bootentry;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.works.bootentry")
public class Config {

	@Bean(name = "sum")
	public Actor sumFnc() {
		Actor ac = new Actor();
		ac.setActor_id(10);
		ac.setFirst_name("Erkan");
		ac.setLast_name("Bilsin");
		ac.setLast_update(new Date());
		return ac;
	}
	
	@Bean(name = "dataSource")
	public DriverManagerDataSource dtConnet() {
		DriverManagerDataSource dm = new DriverManagerDataSource();
		dm.setDriverClassName("com.mysql.jdbc.Driver");
		dm.setUrl("jdbc:mysql://localhost/sakila?useUnicode=true&characterEncoding=utf-8");
		dm.setUsername("root");
		dm.setPassword("");
		return dm;
	}
	
	
}
