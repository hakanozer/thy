package appPack;

public class X extends Util {
	
	public X() {
		super("Util Data");
		System.out.println("X kurucu call");
	}

	public void set() {
		call();
	}
	
	@Override
	public void call() {
		sum(10, 40);
		System.out.println("X call()");
	}
	

	
	
}
