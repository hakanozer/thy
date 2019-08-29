package com.works.bootentry;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@RequestMapping(value = "/allUser", method = RequestMethod.GET)
	public HashMap<String, Object> allUser() {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("statu", true);
		hm.put("username", "Ali");
		hm.put("surname", "Bilmem");
		return hm;
	}
	
	
}
