import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAccount {

	private JFrame frmAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount window = new CreateAccount();
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
	public CreateAccount() {
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
				
				createAdm.main(null);
			}
		});
		btnAdminAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdminAccount.setBounds(15, 65, 198, 29);
		frmAdmin.getContentPane().add(btnAdminAccount);
		
		JButton btnProfessorAccount = new JButton("Professor Account");
		btnProfessorAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdmin.dispose();
		
				createProf.main(null);
			}
		});
		btnProfessorAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnProfessorAccount.setBounds(15, 110, 198, 29);
		frmAdmin.getContentPane().add(btnProfessorAccount);
		
		JButton btnStudentAccount = new JButton("Student Account");
		btnStudentAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdmin.dispose();
			
				createStud.main(null);
			}
		});
		btnStudentAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStudentAccount.setBounds(15, 155, 198, 29);
		frmAdmin.getContentPane().add(btnStudentAccount);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdmin.dispose();
			
				AdminAccount.main(null);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(276, 199, 115, 29);
		frmAdmin.getContentPane().add(btnExit);
	}

}
