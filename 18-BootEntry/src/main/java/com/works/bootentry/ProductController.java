package com.works.bootentry;

import java.sql.PreparedStatement;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

	@Autowired Actor sum;
	@Autowired DriverManagerDataSource dataSource;
	
	@RequestMapping(value = "/open", method = RequestMethod.GET)
	public @ResponseBody String open() {
		return "open calll";
	}
	
	
	@RequestMapping(value = "/openx", method = RequestMethod.GET)
	public String call(Model model) {
		/*
		try {
			PreparedStatement pre = dataSource.getConnection().prepareStatement("");
		} catch (Exception e) {
			System.err.println("hata !");
		}*/
		
		model.addAttribute("data", "Spring Boot");
		model.addAttribute("sum", sum);
		return "call";
	}
	
	
	
}
