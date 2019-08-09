package appPack;

public class Util implements Runnable {

	@Override
	public void run() {
		// thread start olduğunda yapılacak işlemler
		// thread uyutma
		try {
			for(int i = 0; i < 100; i++) {
				System.out.println("callMtd calling");
				//Thread.sleep(2000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
