package appPack;

import java.util.ArrayList;
import java.util.Collections;

public class MainArrayList {

	public static void main(String[] args) {
		
		
		String[] arr = new String[5];
		ArrayList<String> ls = new ArrayList<>();
		
		// add
		ls.add("Ali");
		ls.add("Mehmet");
		ls.add("Ayşe");
		ls.add("Hasan");
		
		// index
		System.out.println(ls.get(1));
		
		// all index
		System.out.println(ls);
		
		// java 8 lambda foreach
		ls.forEach(item -> {
			// yapılacak işlemler
			System.out.println(item);
		});
		
		
		
		// sort
		Collections.sort(ls);
		
		// foreach item
		for (String item : ls) {
			System.out.println(item);
		}
		
		
		// delete item
		ls.remove(0);
		ls.remove("Hasan");
		
		// all items delete
		ls.clear();
		
		// size
		System.out.println("------------------------");
		int count = ls.size();
		for(int i = 0; i<ls.size(); i++) {
			System.out.println(ls.get(i));
		}
		
		
		

	}

}
