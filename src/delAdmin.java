import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class delAdmin {
	// THIS DELETES 
	JFrame frmAdmin;
	private JTextField accTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delAdmin window = new delAdmin();
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
	public delAdmin() {
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
		lblAccount.setBounds(42, 104, 95, 20);
		frmAdmin.getContentPane().add(lblAccount);
		
		accTextField = new JTextField();
		accTextField.setBounds(142, 101, 146, 26);
		frmAdmin.getContentPane().add(accTextField);
		accTextField.setColumns(10);
		
		JButton btnExit = new JButton("Delete");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passd = accTextField.getText();
			
				try {
					WriteAndUpdate.removeLine("AdminPassword.txt", passd);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				accTextField.setText("");
		
				frmAdmin.dispose();
				
				AdminAccount.main(null);
			}
			
			
			
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(298, 185, 115, 29);
		frmAdmin.getContentPane().add(btnExit);
	}
}
