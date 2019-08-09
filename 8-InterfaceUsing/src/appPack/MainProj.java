package appPack;


public class MainProj {

	public static void main(String[] args) {
		
		User us = new Util();
		
		User usx = new User() {
			
			@Override
			public int sum(int a, int b) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public char cn() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		usx.cn();
		usx.sum(10, 40);
		
		User.Settings st = new User.Settings();

	}

}
