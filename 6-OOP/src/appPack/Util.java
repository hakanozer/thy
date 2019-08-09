package appPack;

// javada sınıf ismi ile dosya ismi aynı olmak zorundadır.
public class Util {

	// kurucu
	// Yazılmadığında default halde bir adet vardır ve tetiklenir.
	// Method ismi ile sınıf ismi aynı olmalıdır.
	// void yada return kelimeli alamazlar.
	// Erişim belirteçleri alırlar.
	
	String dt = "";
	public Util() {
		System.out.println("Util call");
		monitor();
	}
	
	public Util(String data) {
		System.out.println("Util call " + data);
		dt = data;
		monitor();
	}
	
	public void monitor() {
		if(dt.equals("")) {
			System.out.println("dt boş işlemi yapıyor");
		}else {
			System.out.println("dt dolu işlem yapıyor");
		}
	}
	
	
}

class y {
	
}

class x {
	
}
