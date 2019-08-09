package appPack;

public interface User {

	public int sum(int a, int b);
	public char cn();
	default public void control(String st) {
		System.out.println("Control Call()");
		new Settings();
	}
	int a = 10;
	class Settings {
		public Settings() {
			System.out.println("Settings call");
		}
	}
	
}
