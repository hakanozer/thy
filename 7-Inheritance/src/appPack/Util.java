package appPack;

public class Util {
	
	public Util() {
		System.out.println("Util kurucu call");
	}
	
	public Util(String data) {
		System.out.println("Util kurucu call " + data);
	}
	
	
	int num = 10;
	public void call() {
		System.out.println("Util call()");
	}
	
	final public void sum(int a, int b) {
		int sm = a + b;
		System.out.println("Sum : " + sm);
	}

}
