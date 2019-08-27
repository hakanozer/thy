package com.works.bootentry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB {

	final private String url = "jdbc:mysql://localhost/sakila?useUnicode=true&characterEncoding=utf-8";
	final private String userName = "root";
	final private String userPass = "";
	final private String driver = "com.mysql.jdbc.Driver";
	
	private Connection conn = null;
	private PreparedStatement pre = null;
	
	public DB() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, userPass);
			System.out.println("Connected");
		} catch (SQLException | ClassNotFoundException  e) {
			System.err.println("Connection Error : " + e);
		}
	}
	
	
	public PreparedStatement connect(String query) {
		try {
			pre = conn.prepareStatement(query);
		} catch (Exception e) {
			System.err.println("Prepared error : " + e);
		}
		return pre;
	} 
	
}
