package appPack;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateForm {

	public JFrame frame;
	DB db = new DB();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateForm window = new UpdateForm();
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
	public UpdateForm() {
		initialize();
	}

	int uid = 0;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtMail;
	private JTextField txtPass;
	public UpdateForm(String id) {
		uid = Integer.valueOf(id);
		initialize();
		pullData();
	}

	void pullData() {
		try {
			String query = "select * from users where uid = ?";
			PreparedStatement pre = db.connect(query);
			pre.setInt(1, uid);
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				String u = rs.getString("uname");
				String s = rs.getString("usurname");
				String m = rs.getString("umail");
				String p = rs.getString("upass");
				txtName.setText(u);
				txtSurname.setText(s);
				txtMail.setText(m);
				txtPass.setText(p);
			}
		} catch (Exception e) {
			System.err.println("update pull error : " + e);
		}
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(98, 34, 226, 26);
		frame.getContentPane().add(txtName);
		
		txtSurname = new JTextField();
		txtSurname.setColumns(10);
		txtSurname.setBounds(98, 72, 226, 26);
		frame.getContentPane().add(txtSurname);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(98, 110, 226, 26);
		frame.getContentPane().add(txtMail);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(98, 148, 226, 26);
		frame.getContentPane().add(txtPass);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n = txtName.getText().trim();
				String s = txtSurname.getText().trim();
				String m = txtMail.getText().trim();
				String p = txtPass.getText().trim();
				pushUpdate(n,s,m,p);
			}
		});
		btnUpdate.setBounds(98, 189, 226, 38);
		frame.getContentPane().add(btnUpdate);
	}

	protected void pushUpdate(String n, String s, String m, String p) {
		
		try {
			String query = "update users set uname = ?, usurname = ?, umail = ?, upass = ? where uid = ?";
			PreparedStatement pre = db.connect(query);
			pre.setString(1, n);
			pre.setString(2, s);
			pre.setString(3, m);
			pre.setString(4, p);
			pre.setInt(5, uid);
			int statu = pre.executeUpdate();
			if (statu > 0) {
				MainForm mn = new MainForm();
				mn.frame.setVisible(true);
				frame.dispose();
			}
		} catch (Exception e) {
			System.err.println("update error : " + e);
		}
		
	}

}
