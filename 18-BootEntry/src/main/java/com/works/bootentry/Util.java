package com.works.bootentry;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class Util {
	
	
	
	public static HashMap<String, Object> restControl(String api_key, HashMap<String, Object> hm) {
		HashMap<String, Object> rhm = new HashMap<>();
			if (!api_key.equals("") && api_key.length() == 32) {
			DB db = new DB();
			try {
				String query = "select * from admin where api_key = ?";
				PreparedStatement pre = db.connect(query);
				pre.setString(1, api_key);
				ResultSet rs = pre.executeQuery();
				if(rs.next()) {
					return hm;
				}else {
					rhm.put("statu", false);
					rhm.put("message", "API Key error!");
				}
			} catch (Exception e) {
				System.err.println("api_key error : " + e);
				rhm.put("statu", false);
				rhm.put("message", "API Key error! " + e);
			}
		}else {
			rhm.put("statu", false);
			rhm.put("message", "API Key Length Problem ");
		}	
		
		return rhm;
	}

}
