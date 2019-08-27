import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfessorAccount {

	private JFrame frmProfessor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfessorAccount window = new ProfessorAccount();
					window.frmProfessor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProfessorAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProfessor = new JFrame();
		frmProfessor.setTitle("Professor");
		frmProfessor.setBounds(100, 100, 450, 300);
		frmProfessor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProfessor.getContentPane().setLayout(null);
		
		JButton btnPostHw = new JButton("HW");
		btnPostHw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmProfessor.dispose();
			
				HW.main(null);
			}
		});
		btnPostHw.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPostHw.setBounds(15, 38, 156, 29);
		frmProfessor.getContentPane().add(btnPostHw);
		
		JButton btnPostGrades = new JButton("Grades");
		btnPostGrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmProfessor.dispose();
				
				Grades.main(null);
			}
		});
		btnPostGrades.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPostGrades.setBounds(15, 101, 156, 29);
		frmProfessor.getContentPane().add(btnPostGrades);
		
		JButton btnCreateArticles = new JButton("Article(s)");
		btnCreateArticles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProfessor.dispose();
				
				Articles.main(null);
			}
		});
		btnCreateArticles.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCreateArticles.setBounds(15, 158, 156, 29);
		frmProfessor.getContentPane().add(btnCreateArticles);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProfessor.dispose();
			
				AccountLogin.main(null);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogout.setBounds(298, 199, 115, 29);
		frmProfessor.getContentPane().add(btnLogout);
	}

}
