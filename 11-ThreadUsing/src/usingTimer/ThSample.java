package usingTimer;

public class ThSample extends Thread implements TaskInterface, Runnable {
		
	 String data = "";
	 public ThSample(String data) {
		this.data = data;
	}
	
	@Override
	public void call() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void run() {
		for (;;) {
			
				
				try {
					System.out.println(data);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
	}

}
