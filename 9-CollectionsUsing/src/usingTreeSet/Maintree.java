package usingTreeSet;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Maintree {
	
	ArrayList<String> ls = new ArrayList<>();

	public static void main(String[] args) {
		
		Set<String> st = new TreeSet<>();
		st.add("Ali");
		st.add("Veli");
		st.add("Ali");
		st.add("Hasan");
		
		for (String item : st) {
			System.out.println(item);
		}
		
		Maintree mn = new Maintree();
		mn.ls.add("ali");		
		mn.add("ahmet");
		mn.add("serkan");
		mn.add("mehmet");
		mn.add("hasan");
		mn.add("ahmet");
		
		System.out.println(mn.ls);
	}
	
	/*
	 ali
	 mehmet
	 hasan
	 ahmet
	 serkan
	 */
	// ahmet
	boolean statu = false;
	 void add(String addData) {
		ls.forEach(item -> {
			if(item.equals(addData)) {
				statu = true;
				return;
			}
		});
		if(!statu) {
			ls.add(addData);
		}
		statu = false;
	}
	
}
