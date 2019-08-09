package proArrayList;

import java.util.ArrayList;

public class MainProArrayList {
	
	ArrayList<UserPro> ls = new ArrayList<>();

	public static void main(String[] args) {
		MainProArrayList mn = new MainProArrayList();
		mn.dataResult();
	}
	
	public void dataResult() {
		for (int i = 0; i < 10; i++) {
			UserPro us = new UserPro();
			us.setMail("mail@mail.com - " + i);
			us.setName("ali - " + i);
			us.setPass("1234 - " + i);
			us.setSurname("bilmem - " + i);
			ls.add(us);
		}
		dataPrint();
	}

	private void dataPrint() {
		ls.forEach(item -> {
			System.out.println(item.getName());
		});
	}

}
