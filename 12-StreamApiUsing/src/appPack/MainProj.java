package appPack;

import java.util.ArrayList;
import java.util.List;

public class MainProj {

	List<Users> ls = new ArrayList<Users>();
	
	public static void main(String[] args) {
		MainProj mn = new MainProj();
		mn.dataResult();
		
		long start1 = System.currentTimeMillis();
		System.out.println("start1 : " + start1);
		for (Users item : mn.ls) {
			//System.out.println(item);
			if(item.getName().equals("Ali") && item.getAge() > 0) {
				//System.out.println(item.getAge());
			}
		}
		long end1 = System.currentTimeMillis();
		System.out.println("end1 : " + end1);
		long c1 = end1 - start1;
		System.out.println("c1 : " + c1);
		
		
		MainProj mnl = new MainProj();
		mnl.dataResult();
		// java 8
		long start2 = System.currentTimeMillis();
		System.out.println("start2 : " + start2);
		mnl
		.ls
		.stream()
		.filter(item -> item.getName().equals("Ali"))
		.filter(item -> item.getAge() > 0)
		.forEach(item -> {
			
		});
		long end2 = System.currentTimeMillis();
		System.out.println("end2 : " + end2);
		long c2 = end2 - start2;
		System.out.println("c2 : " + c2);
		
	}
	
	
	void dataResult() {
		for (int i = 0; i < 1000000; i++) {
			ls.add(new Users("Ali", "Bilmem", 30, false));
			ls.add(new Users("Mehmet", "Bilirim", 30, false));
			ls.add(new Users("Serkan", "Bilki", 30, false));
			ls.add(new Users("Ayşe", "Bilmez", 30, false));
			ls.add(new Users("Erkan", "Biliyor", 30, false));
			ls.add(new Users("Selim", "Bilirler", 30, false));
			ls.add(new Users("Selin", "Bil", 30, false));
			ls.add(new Users("Saygın", "Bilir", 30, false));
			ls.add(new Users("Sevil", "bilmezki", 30, false));
			ls.add(new Users("Sevgi", "Bili", 30, false));
			ls.add(new Users("Su", "Bill", 30, false));
		}
	}
	
	
	

}
