package appPack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApp() {
		// DB active
		// new thread
		/*
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCallMethod = new JButton("Call Method");
		btnCallMethod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				callMtd();
			}
		});
		btnCallMethod.setBounds(144, 36, 129, 44);
		frame.getContentPane().add(btnCallMethod);
		
		JButton btnSecondFnc = new JButton("Second Fnc");
		btnSecondFnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("I'm Run Calling");
			}
		});
		btnSecondFnc.setBounds(154, 92, 117, 29);
		frame.getContentPane().add(btnSecondFnc);
		
		JButton btnJavaThread = new JButton("Java 8 Thread");
		btnJavaThread.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java8lambdaThread();
			}
		});
		btnJavaThread.setBounds(144, 139, 143, 52);
		frame.getContentPane().add(btnJavaThread);
	}

	protected void java8lambdaThread() {
		
		Runnable rn = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("rn for call");
			}
		};
		Thread th1 = new Thread(rn);
		th1.start();
		
		// ilişkilendirme
		try {
			th1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Runnable rn1 = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("rn1 for call");
			}
		};
		Thread th2 = new Thread(rn1);
		
		if(!th1.isAlive()) {
			th2.start();
		}
		
		
	}

	protected void callMtd() {
		Thread th = new Thread(new Util(), "utilThread");
		Thread th1 = new Thread(new Settings(), "settingsThread");
		th.start();
		
		// thread öldürme
		//th.interrupt();
		//th = null;
		
		if(th.isAlive()) {
			System.out.println("Thread Yaşıyor");
		}else {
			System.out.println("Thread ölmüş");
		}
		
		try {
			//Süre ile bekletmek için milisn cinsinden değer atılır.
			// iş bitiminde farklı thread tetiklemek için thread nesnesi atılır.
			th.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // thread yaşam zamanı
		
		if(th.isAlive()) {
			System.out.println("Thread Yaşıyor");
		}else {
			th1.start(); // th nesnesi işlemi bitmiş ise th1 yaşat.
			System.out.println("Thread ölmüş");
		}
		
	}
}
