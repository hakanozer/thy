package com.works.bootentry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired DriverManagerDataSource dataSource;
	
	// sistem çalışmadan önce vt sorgusu yapılacak fnc
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.authoritiesByUsernameQuery("select mail, role from admin where mail = ?")
		.usersByUsernameQuery("select mail,pass, 1 from admin where mail = ?");
	}
	
	
	// giriş başarılı ise yapılacak işlemler
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        
		http
		.httpBasic()
		.and()
        .authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/admin/**").hasAuthority("ADMIN")
        .antMatchers("/user/**").hasAuthority("USER")
        .anyRequest()
        .authenticated().and().csrf().disable();
		 
	}
	
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

}
