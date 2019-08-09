package appPack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class MainForm {
	
	DB db = new DB();

	public JFrame frame;
	JTextArea textArea;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtMail;
	private JTextField txtPass;
	private JButton btnDataGetir;
	private JButton btnNewButton_1;
	private JTextField txtID;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
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
	public MainForm() {
		initialize();
		allDataResult();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 611, 321);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(105, 50, 226, 26);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setColumns(10);
		txtSurname.setBounds(105, 88, 226, 26);
		frame.getContentPane().add(txtSurname);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(105, 126, 226, 26);
		frame.getContentPane().add(txtMail);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(105, 164, 226, 26);
		frame.getContentPane().add(txtPass);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n = txtName.getText().trim();
				String s = txtSurname.getText().trim();
				String m = txtMail.getText().trim();
				String p = txtPass.getText().trim();
				insert(n,s,m,p);
			}
		});
		btnNewButton.setBounds(105, 205, 226, 38);
		frame.getContentPane().add(btnNewButton);
		
		btnDataGetir = new JButton("All Data Result");
		btnDataGetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allDataResult();
			}
		});
		btnDataGetir.setBounds(354, 50, 156, 29);
		frame.getContentPane().add(btnDataGetir);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setBounds(361, 88, 149, 64);
		frame.getContentPane().add(textArea);
		
		btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(isNum(txtID.getText().trim())) {
					int id = Integer.valueOf(txtID.getText());
					deleteRow("users", "uid", id);
				}else {
					JOptionPane.showMessageDialog(frame, "Lütfen sadece tam sayı giriniz");
				}
				/*
				try {
					int id = Integer.valueOf(txtID.getText());
					deleteRow("users", "uid", id);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, "Lütfen sadece tam sayı giriniz");
				}*/
				
			}
		});
		btnNewButton_1.setBounds(354, 205, 156, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		txtID = new JTextField();
		txtID.setBounds(354, 177, 156, 26);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		btnNewButton_2 = new JButton("Update Item");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateForm up = new UpdateForm(txtID.getText().trim());
				up.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(353, 242, 157, 38);
		frame.getContentPane().add(btnNewButton_2);
	}
	
	protected boolean isNum(String data) {
		data = data.replaceAll("", " ");
		char[] arr = data.toCharArray();
		if(data.length() == 0) return false;
		for (char item : arr) {
			if(!Character.isDigit(item)) {
				return false;
			}
		}
		return true;
	}

	protected void deleteRow(String tableName, String columnName, int id) {
		try {
			String query = "delete from " + tableName + " where " + columnName + " = ?";
			PreparedStatement pre = db.connect(query);
			pre.setInt(1, id);
			if(pre.executeUpdate() > 0 ) {
				allDataResult();
			}
		} catch (Exception e) {
			System.err.println("delete error : " + e);
		}
	}

	protected void allDataResult() {
		textArea.setText("");
		try {
			String query = "select * from users limit 0,10";
			PreparedStatement pre = db.connect(query);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				// her satır için yapılacak işlemler
				String name = rs.getString("uname");
				System.out.println(name);
				textArea.append(name + System.lineSeparator());
			}
		} catch (Exception e) {
			System.err.println("data result error : " + e);
		}
		
	}

	protected void insert(String n, String s, String m, String p) {
		try {
			String query = "insert into users values(null, ?, ?, ?, ?)";
			PreparedStatement pre = db.connect(query);
			pre.setString(1, n);
			pre.setString(2, s);
			pre.setString(3, m);
			pre.setString(4, p);
			int statu = pre.executeUpdate();
			if(statu > 0) {
				allDataResult();
				JOptionPane.showMessageDialog(frame, "Ekleme işlemi başarılı");
			}
		} catch (Exception e) {
			System.err.println("insert error : " + e);
		}
	}
}
