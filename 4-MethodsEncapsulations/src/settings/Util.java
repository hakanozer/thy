package settings;

public class Util {

	// defaul -> protected'a benzer. sadece kendi pakentin içinde görün.
	// public -> proje içindeki her yerden görün
	
	int num = 10;
	
	//private -> sadece kendi sınıfının içerisinde görünme yeteneği vardır.
	private String name = "Hasan";
	
	// protected -> kendi paketinin içindeki sınıflar tarafından görünme yetene
	protected boolean statu = true;
	
	final String surname = "Bilmem";
	String soyadi = "Bilmem";
	
	// parametresiz methodlar
	public void noParameter( ) {
		for (int i = 0; i < 10; i++) {
			if (i == 5) return;
			System.out.println("İtem : " + i);
		}
	}
	
	
	public int countString(String data) {
		return data.length();
	}
	
	// birden fazla değer dönderme
	public String[] allRetrun() {
		String[] arr = { "Ali","Veli","Hasan","Mehmet" };
		return arr;
	}
	
	
	public void parameters(String ... args  ) {
		for (String item : args) {
			System.out.println(item);
		}
	}
	
	
	public String call() {
		return "";
	}

	public String call(int a) {
		return "";
	}
	
	public int call(int a, int b) {
		return 10;
	}
	
	
	
	
	
	
}
