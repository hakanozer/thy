package util;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	static List<User> ls = new ArrayList<User>();
	public static List<User> dataResult() {
		return ls;
	}
	
	
	public static void userAdd(String id, String name, String surname) {
		int did = Integer.valueOf(id);
		User u = new User();
		u.setId(did);
		u.setName(name);
		u.setSurname(surname);
		ls.add(u);
	}

}
