import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class createProf {

	private JFrame frmAdmin;
	private JTextField accTextField;
	private JPasswordField passTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createProf window = new createProf();
					window.frmAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public createProf() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdmin = new JFrame();
		frmAdmin.setTitle("Admin");
		frmAdmin.setBounds(100, 100, 450, 300);
		frmAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdmin.getContentPane().setLayout(null);
		
		JLabel lblAccount = new JLabel("Account:");
		lblAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAccount.setBounds(44, 71, 102, 20);
		frmAdmin.getContentPane().add(lblAccount);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(44, 132, 102, 20);
		frmAdmin.getContentPane().add(lblPassword);
		
		accTextField = new JTextField();
		accTextField.setBounds(161, 68, 146, 26);
		frmAdmin.getContentPane().add(accTextField);
		accTextField.setColumns(10);
		
		passTextField = new JPasswordField();
		passTextField.setBounds(161, 129, 146, 26);
		frmAdmin.getContentPane().add(passTextField);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String acc = accTextField.getText();
				String pass = passTextField.getText();
				
				
				try(PrintWriter output = new PrintWriter(new FileWriter("ProfessorPassword.txt",true))) 
				{
				    output.printf("%s\r\n", acc + " " + pass);
				} 
				catch (Exception e1) {}
			
				
				accTextField.setText("");
				passTextField.setText(" ");
				
				frmAdmin.dispose();
				AdminAccount.main(null);
			
			
			}});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCreate.setBounds(298, 199, 115, 29);
		frmAdmin.getContentPane().add(btnCreate);
	}

}
