import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileSystemView;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class Grades {

	private JFrame frmGrades;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grades window = new Grades();
					window.frmGrades.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Grades() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGrades = new JFrame();
		frmGrades.setTitle("Grades");
		frmGrades.setBounds(100, 100, 450, 300);
		frmGrades.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGrades.getContentPane().setLayout(null);
		
		JTextArea jTextArea1 = new JTextArea();
		jTextArea1.setBounds(9, 11, 328, 197);
		frmGrades.getContentPane().add(jTextArea1);
		
		JScrollPane scrollBar = new JScrollPane(jTextArea1);
		scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		frmGrades.getContentPane().add(scrollBar);
		scrollBar.setBounds(13, 39, 413, 189);
		
		try {
			copyDirectory.copyDirectory(new File("Grades"), new File("Main Grades"));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		JButton btnNewButton = new JButton("Read Text");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileSystemView fsv = new DirectoryRestrictedFileSystemView(new File("Main Grades"));
				JFileChooser chooser = new JFileChooser(fsv.getHomeDirectory(),fsv);
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String nameFile = f.getAbsolutePath();
				
				try {
					
					FileReader reader = new FileReader(nameFile);
					BufferedReader br = new BufferedReader(reader);
					jTextArea1.read(br, null);
					br.close();
					jTextArea1.requestFocus();
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
				
				
			}
		});
		btnNewButton.setBounds(15, 11, 115, 24);
		frmGrades.getContentPane().add(btnNewButton);
		

		JButton btnWriteText = new JButton("Write Text");
		btnWriteText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {

					String fileName = JOptionPane.showInputDialog(null, "Please enter the student ID that this grade belongs to");
					FileWriter writer = new FileWriter("Grades\\"+ fileName +".txt");
					BufferedWriter bw = new BufferedWriter (writer);
					File file = new File("Activity Log\\Activity Log.txt");
					FileWriter fr = new FileWriter(file, true);
					PrintWriter pr = new PrintWriter(fr); 
					pr.println("Grade for student " + fileName + " has been posted."); 
					pr.close();
					fr.close();
					jTextArea1.write(bw);
					bw.close();
					jTextArea1.setText("");
					jTextArea1.requestFocus();
					
					frmGrades.dispose();
					
					ProfessorAccount.main(null);
				
			}
			catch(Exception e1) {
				JOptionPane.showMessageDialog(null, e1);
		    	}
	    	}
			
		});
		btnWriteText.setBounds(154, 11, 115, 24);
		frmGrades.getContentPane().add(btnWriteText);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmGrades.dispose();
				ProfessorAccount.main(null);
			}
		});
		btnBack.setBounds(298, 11, 115, 24);
		frmGrades.getContentPane().add(btnBack);
	}
}
