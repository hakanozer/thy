package com.works.bootentry;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

	
	@RequestMapping(value = "/open", method = RequestMethod.GET)
	public @ResponseBody String open() {
		return "open calll";
	}
	
	
	
}
