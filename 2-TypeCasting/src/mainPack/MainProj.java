package mainPack;

public class MainProj {

	public static void main(String[] args) {
		
		// String to int
		String age = "30";
		int cage = Integer.valueOf(age);
		System.out.println("cage : " + cage);
		double dage = Double.valueOf(cage);
		System.out.println("dage : " + dage);
		
		float d1 = 10;
		int f1 = (int) d1;
		
		// char
		char c1 = '9';
		int dc1 = Integer.valueOf(c1+"");
		System.out.println("dc1 : " + dc1);

		// Object - class
		Object obj = "Mehmet";
		obj = 10;
		obj = true;
		obj = 10.1;
		
		// double cast
		Double db = (Double) obj;
		
		if (obj instanceof Double) {
			System.out.println("obj Double");
		}
		
		
		
	}
	
}
