package com.works.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class IncluderController {
	
	@RequestMapping(value = "/css", method = RequestMethod.GET)
	public String dashBoard() {
		return "admin/inc/css";
	}
	
}
