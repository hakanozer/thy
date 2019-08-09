package usingTimer;

import java.util.Timer;
import java.util.TimerTask;

public class MainTimer {

	public static void main(String[] args) {
		MainTimer mn = new MainTimer();
		Timer tm = new Timer();
		tm.schedule(mn.task, 0, 500);
		
		
		ThSample ts = new ThSample("Audi");
		ts.start();
		
		ThSample ts1 = new ThSample("Murat");
		ts1.start();
		
	}
	
	TimerTask task = new TimerTask() {
		@Override
		public void run() {
			System.out.println("TimerTask Call");
		}
	};

}
