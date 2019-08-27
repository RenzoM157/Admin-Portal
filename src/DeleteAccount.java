import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteAccount {

	private JFrame frmAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteAccount window = new DeleteAccount();
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
	public DeleteAccount() {
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
		
		JButton btnAdminAccount = new JButton("Admin Account");
		btnAdminAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdmin.dispose();
				
				delAdmin.main(null);
			}
		});
		btnAdminAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdminAccount.setBounds(15, 43, 186, 29);
		frmAdmin.getContentPane().add(btnAdminAccount);
		
		JButton btnProfessorAccount = new JButton("Professor Account");
		btnProfessorAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdmin.dispose();
				
				delProfessor.main(null);
			}
		});
		btnProfessorAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnProfessorAccount.setBounds(15, 102, 186, 29);
		frmAdmin.getContentPane().add(btnProfessorAccount);
		
		JButton btnStudentAccount = new JButton("Student Account");
		btnStudentAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdmin.dispose();
			
				delStudent.main(null);
			}
		});
		btnStudentAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStudentAccount.setBounds(15, 158, 186, 29);
		frmAdmin.getContentPane().add(btnStudentAccount);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdmin.dispose();
				
				AdminAccount.main(null);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(270, 199, 115, 29);
		frmAdmin.getContentPane().add(btnExit);
	}

}
