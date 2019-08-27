import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentAccount {

	private JFrame frmStudent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentAccount window = new StudentAccount();
					window.frmStudent.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudent = new JFrame();
		frmStudent.setTitle("Student");
		frmStudent.setBounds(100, 100, 450, 300);
		frmStudent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudent.getContentPane().setLayout(null);
		
		JButton btnSubmitAssignment = new JButton("Submit Assignment");
		btnSubmitAssignment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStudent.dispose();
				
				StudentHW.main(null);
			}
		});
		btnSubmitAssignment.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSubmitAssignment.setBounds(15, 51, 200, 29);
		frmStudent.getContentPane().add(btnSubmitAssignment);
		
		JButton btnViewGrades = new JButton("View Grades");
		btnViewGrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStudent.dispose();
				
				ViewGrade.main(null);
			}
		});
		btnViewGrades.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewGrades.setBounds(15, 108, 200, 29);
		frmStudent.getContentPane().add(btnViewGrades);
		
		JButton btnViewArticles = new JButton("View Articles");
		btnViewArticles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStudent.dispose();
				ArticlesStudent.main(null);
			}
		});
		btnViewArticles.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewArticles.setBounds(15, 164, 200, 29);
		frmStudent.getContentPane().add(btnViewArticles);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStudent.dispose();
				
				AccountLogin.main(null);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogout.setBounds(298, 199, 115, 29);
		frmStudent.getContentPane().add(btnLogout);
	}

}
