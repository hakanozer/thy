package polimorfizm;

public class Y extends X {

	@Override
	public void call() {
		System.out.println("Y call");
	}
	
	public void sum(int a, int b) {
		int sm = a + b;
		System.out.println("Sum : " + sm );
	}
	
}
