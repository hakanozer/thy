package com.works.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import util.Util;

@Controller
@RequestMapping("/admin")
public class IncluderController {
	
	@RequestMapping(value = "/css", method = RequestMethod.GET)
	public String dashBoard() {
		return "admin/inc/css";
	}
	
	@RequestMapping(value = "/js", method = RequestMethod.GET)
	public String js() {
		return "admin/inc/js";
	}
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(Model model) {
		model.addAttribute("link", Util.link);
		return "admin/inc/menu";
	}
	
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public String header() {
		return "admin/inc/header";
	}
	
}
