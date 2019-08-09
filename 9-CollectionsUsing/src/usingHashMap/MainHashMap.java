package usingHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MainHashMap {
	
	List<HashMap<UserEnum, Object>> hmo = new ArrayList<>();

	public static void main(String[] args) {
		
		MainHashMap ns = new MainHashMap();
		ns.dataResult();
		
		HashMap<String, Object> hm = new HashMap<>();
		
		// add
		hm.put("name", "Ali");
		hm.put("surname", "Bilmem");
		hm.put("age", 30);
		hm.put("statu", true);
		
		// print
		System.out.println(hm);
		
		// item
		System.out.println(hm.get("surname"));
		
		
		// enum hashmap
		HashMap<UserEnum, Object> hme = new HashMap<>();
		hme.put(UserEnum.name, "Mehmet");
		hme.put(UserEnum.surname, "Bilirim");
		hme.put(UserEnum.age, 35);
		hme.put(UserEnum.statu, false);
		
		
		System.out.println(hme.get(UserEnum.surname));
		
		// keys
		Set<String> keys = hm.keySet();
		for (String key : keys) {
			System.out.println(key);
		}
		System.out.println("--------------------------");
		// keys enum
		Set<UserEnum> keysEnum = hme.keySet();
		for (UserEnum item : keysEnum) {
			System.out.println(item);
		}
		
		System.out.println("--------------------------");
		// java 8 lambda (key, val)
		hme.forEach((key,val) -> {
			System.out.println("key : " + key + " val : " + val);
		});
		
		
	}
	
	void dataResult() {
		HashMap<UserEnum, Object> hm = null;
		for (int i = 0; i < 10; i++) {
			hm = new HashMap<>();
			hm.put(UserEnum.name, "Mehmet"+i);
			hm.put(UserEnum.surname, "Bilirim"+i);
			hm.put(UserEnum.age, 35+i);
			hm.put(UserEnum.statu, false);
			hmo.add(hm);
		}
		
		hmo.forEach(item -> {
			String name = ""+ item.get(UserEnum.name);
			System.out.println(name);
		});
		
	}
	
	

}
