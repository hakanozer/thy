package com.works.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class LoginController {
	
	// @RequestMapping("/admin") -> bu gövde altındaki tüm yönlenmeler /admin almak zorundadır.
	
	// login page create
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		return "admin/login";
	}
	
	

}
