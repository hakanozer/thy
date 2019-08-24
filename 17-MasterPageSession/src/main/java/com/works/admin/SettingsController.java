package com.works.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import util.Util;

@Controller
@RequestMapping("/admin")
public class SettingsController {

	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public String settings( HttpServletRequest req ) {
		return Util.control(req, "settings");
	}
	
}
