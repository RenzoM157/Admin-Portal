import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JPasswordField;

public class createAdm {

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
					createAdm window = new createAdm();
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
	public createAdm() {
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
		
		JLabel lblAccount = new JLabel("Account: ");
		lblAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAccount.setBounds(41, 63, 89, 20);
		frmAdmin.getContentPane().add(lblAccount);
		
		accTextField = new JTextField();
		accTextField.setBounds(145, 63, 146, 26);
		frmAdmin.getContentPane().add(accTextField);
		accTextField.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String acc = accTextField.getText();
				String pass = passTextField.getText();
				
				
				try(PrintWriter output = new PrintWriter(new FileWriter("AdminPassword.txt",true))) 
				{
				    output.printf("%s\r\n", acc + " " + pass);
				} 
				catch (Exception e1) {}
			
				
				accTextField.setText("");
				passTextField.setText(" ");
				
				frmAdmin.dispose();
				AdminAccount.main(null);
				
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCreate.setBounds(287, 187, 115, 29);
		frmAdmin.getContentPane().add(btnCreate);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(41, 127, 89, 20);
		frmAdmin.getContentPane().add(lblPassword);
		
		passTextField = new JPasswordField();
		passTextField.setBounds(144, 124, 146, 26);
		frmAdmin.getContentPane().add(passTextField);
	}
}
