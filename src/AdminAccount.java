import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AdminAccount {

	private JFrame frmAdmin;
	BufferedReader in,in2,in3,bf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAccount window = new AdminAccount();
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
	public AdminAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdmin = new JFrame();
		frmAdmin.setFont(new Font("Dialog", Font.BOLD, 12));
		frmAdmin.setTitle("Admin ");
		frmAdmin.setBounds(100, 100, 450, 300);
		frmAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdmin.getContentPane().setLayout(null);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdmin.dispose();
				
				CreateAccount.main(null);
			}
		});
		btnCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCreateAccount.setBounds(227, 60, 167, 29);
		frmAdmin.getContentPane().add(btnCreateAccount);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdmin.dispose();
				
				DeleteAccount.main(null);
			}
		});
		btnDeleteAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDeleteAccount.setBounds(25, 137, 167, 29);
		frmAdmin.getContentPane().add(btnDeleteAccount);
		
		JButton btnViewAccounts = new JButton("View Accounts");
	    btnViewAccounts.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {

	            File f = new File("AdminPassword.txt");
	            File f1 = new File("ProfessorPassword.txt");
	            File f2 = new File("StudentPassword.txt");
	            JTextArea ta = new JTextArea(50,100);

	            JScrollPane jsp = new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);        


	            try{

	                in = new BufferedReader(new FileReader(f));
	                in2 = new BufferedReader(new FileReader(f1));
	                in3 = new BufferedReader(new FileReader(f2));
	                String s = new String();
	                String s2 = new String();
	                String s3 = new String();
	                while(((s = in.readLine()) != null)){

	                    ta.append("Admin:");
	                    ta.append(s+"\n\r");
	                }
	                
	                while(((s2 = in2.readLine()) != null)){

	                    ta.append("Professor:");
	                    ta.append(s2+"\n\r");
	                }
	                
	                while(((s3 = in3.readLine()) != null)){

	                    ta.append("Student:");
	                    ta.append(s3+"\n\r");
	                }
	                
	               	                
	                ta.setEditable(false);            
	              
	                ta.scrollRectToVisible(new Rectangle(0, 0, 1, 1)); 
	                JOptionPane.showMessageDialog(btnViewAccounts, jsp);


	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }finally {
	                if (in != null)
	                {
	                    try {
	                        in.close();
	                    } catch (IOException e1) {
	                        e1.printStackTrace();
	                    }
	                }

	                if (in2 != null)
	                {
	                    try {
	                        in2.close();
	                    } catch (IOException e1) {
	                        e1.printStackTrace();
	                    }
	                }

	                if (in3 != null)
	                {
	                    try {
	                        in3.close();
	                    } catch (IOException e1) {
	                        e1.printStackTrace();
	                    }
	                }
	            }




	        } 
	    });
		btnViewAccounts.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewAccounts.setBounds(25, 60, 167, 29);
		frmAdmin.getContentPane().add(btnViewAccounts);
		
		
		JButton btnActivityLog = new JButton("Activity Log");
		btnActivityLog.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {

	            File ff = new File("Activity Log\\Activity Log.txt");
	            
	            JTextArea ta2 = new JTextArea(50,100);

	            JScrollPane jsp2 = new JScrollPane(ta2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);        


	            try{

	                bf = new BufferedReader(new FileReader(ff));
	                String stri = new String();

	                while(((stri = bf.readLine()) != null)){

	              
	                    ta2.append(stri+"\n\r");
	                }
	                
           
	                ta2.setEditable(false);            
	              
	                ta2.scrollRectToVisible(new Rectangle(0, 0, 1, 1)); 
	                JOptionPane.showMessageDialog(btnViewAccounts, jsp2);


	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }finally {
	                if (bf != null)
	                {
	                    try {
	                        bf.close();
	                    } catch (IOException e1) {
	                        e1.printStackTrace();
	                    }
	                }


	        } 
	    }});
		
			
		btnActivityLog.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnActivityLog.setBounds(228, 137, 167, 29);
		frmAdmin.getContentPane().add(btnActivityLog);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAdmin.dispose();
				
				AccountLogin.main(null);
			}
		});
		
		btnLogout.setBounds(279, 199, 115, 29);
		frmAdmin.getContentPane().add(btnLogout);
	}
}
