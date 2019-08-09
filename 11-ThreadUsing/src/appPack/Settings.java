package appPack;

public class Settings implements Runnable {

	@Override
	public void run() {
		// thread start olduğunda yapılacak işlemler
		// thread uyutma
		try {
			for(int i = 0; i < 100; i++) {
				System.out.println("Settings callMtd calling");
				//Thread.sleep(2000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	
}
