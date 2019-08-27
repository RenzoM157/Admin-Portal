import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class delProfessor {

	private JFrame frmAdmin;
	private JTextField accTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delProfessor window = new delProfessor();
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
	public delProfessor() {
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
		lblAccount.setBounds(49, 110, 96, 20);
		frmAdmin.getContentPane().add(lblAccount);
		
		accTextField = new JTextField();
		accTextField.setBounds(146, 107, 146, 26);
		frmAdmin.getContentPane().add(accTextField);
		accTextField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passd = accTextField.getText();
				
				try {
					WriteAndUpdate.removeLine("ProfessorPassword.txt", passd);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				accTextField.setText("");
		
				frmAdmin.dispose();
			
				AdminAccount.main(null);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(279, 187, 115, 29);
		frmAdmin.getContentPane().add(btnDelete);
	}

}
