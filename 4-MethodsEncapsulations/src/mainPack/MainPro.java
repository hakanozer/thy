package mainPack;

import settings.Util;

public class MainPro {
	
	public static void main(String[] args) {
		
		
		Util ut = new Util();
		ut.noParameter();
		int count = ut.countString("Fenerbahçe");
		if(ut.countString("İstanbul") > 5) {
			
		}
		
		String country = null;
		System.out.println(country);
		
		
		String[] arr = ut.allRetrun();
		String aa = arr[2];
		System.out.println(aa);
		
		ut.parameters("ali", "veli","hasan", "serkan");
		
	}

}
