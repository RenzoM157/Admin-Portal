import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class AccountLogin extends JFrame{
	
	public static String currentAccount;
	
	private JPanel contentPane;	
	private JTextField accNumBox;
	public static String user, passw;
	//private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	
	static String accountNo, pass;
	private JPasswordField passwordField;
	
	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					AccountLogin frame = new AccountLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					
				}
				
				
					
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AccountLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccountNumber = new JLabel("Account Number:");
		lblAccountNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAccountNumber.setBounds(43, 79, 150, 20);
		contentPane.add(lblAccountNumber);
		
		accNumBox = new JTextField();
		accNumBox.setBounds(193, 76, 220, 26);
		contentPane.add(accNumBox);
		accNumBox.setColumns(10);
		
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(98, 115, 98, 20);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(193, 118, 220, 26);
		contentPane.add(passwordField);
		
		// admin text file
		ReadPasswordFile acc = new ReadPasswordFile();
		acc.openFile();
		acc.read_file();

		// professor text file
		ProfessorPassFile profacc = new ProfessorPassFile();
		profacc.openFile();
		profacc.read_file();
		
		// student text file
		StudentPassFile studacc = new StudentPassFile();
		studacc.openFile();
		studacc.read_file();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = accNumBox.getText();
				passw = passwordField.getText();
				
				if (ReadPasswordFile.map.get(user) != null && ReadPasswordFile.map.get(user).equals(passw)) // IF ADMIN ACCOUNT
				{
					currentAccount = user;
					ReadPasswordFile.password = passw;
					
					
					JOptionPane.showMessageDialog(contentPane, "Admin Login successful");
					
					//open new frame
				
					AdminAccount.main(null);
					dispose(); // close current frame
				
				}
				else if (ProfessorPassFile.map.get(user) != null && ProfessorPassFile.map.get(user).equals(passw)) // IF PROFESSOR ACCOUNT
				{
					currentAccount = user;
					ProfessorPassFile.password = passw;
					
					
					JOptionPane.showMessageDialog(contentPane, "Professor Login successful");
					
					//open new frame
				
					 
					 ProfessorAccount.main(null);
					dispose(); // close current frame
				
				}
				else if (StudentPassFile.map.get(user) != null && StudentPassFile.map.get(user).equals(passw)) // IF STUDENT ACCOUNT
				{
					currentAccount = user;
					StudentPassFile.password = passw;
					
					
					JOptionPane.showMessageDialog(contentPane, "Student Login successful");
					
					//open new frame
				
					 
					StudentAccount.main(null);
					dispose(); // close current frame
				
				}
				else
				{
				
					JOptionPane.showMessageDialog(contentPane, "Invalid Username/Password!", "Login Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
				acc.close_file();
				profacc.close_file();
				studacc.close_file();
			}
		
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.setBounds(241, 167, 115, 29);
		contentPane.add(btnLogin);
		
		
		
	}
}
