package com.works.bootentry;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {
	
	DB db = new DB();
	
	@RequestMapping(value = "/allActor", method = RequestMethod.GET)
	public HashMap<String, Object> allActor(@RequestHeader HttpHeaders head) {
		System.out.println(head.getDate());
		System.out.println(head.getHost());
		System.out.println(head.getLocation());
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("statu", true);
		hm.put("list", dataResult());
		return hm;
	}
	
	public List<Actor> dataResult() {
		List<Actor> ls = new ArrayList<Actor>();
		try {
			String query = "select * from actor";
			PreparedStatement pr = db.connect(query);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				Actor ac = new Actor();
				ac.setActor_id(rs.getInt("actor_id"));
				ac.setFirst_name(rs.getString("first_name"));
				ac.setLast_name(rs.getString("last_name"));
				ac.setLast_update(rs.getDate("last_update"));
				ls.add(ac);
			}
		} catch (Exception e) {
			System.err.println("dataResult Error : " + e);
		}
		return ls;
	}
	

}
