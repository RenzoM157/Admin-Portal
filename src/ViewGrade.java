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
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;

public class ViewGrade {

	private JFrame frmGrades;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewGrade window = new ViewGrade();
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
	public ViewGrade() {
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
		jTextArea1.setEditable(false);
		
		JScrollPane scrollBar = new JScrollPane(jTextArea1);
		scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		frmGrades.getContentPane().add(scrollBar);
		scrollBar.setBounds(13, 39, 413, 189);
		
		// student text file
				StudentPassFile studacc = new StudentPassFile();
				studacc.openFile();
				studacc.read_file();
			
				
		JButton btnNewButton = new JButton("View Grades");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
							
				FileSystemView fsv = new DirectoryRestrictedFileSystemView(new File("Grades"));
				JFileChooser chooser = new JFileChooser(fsv.getHomeDirectory(),fsv);
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String nameFile = f.getAbsolutePath();
				String x = (f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\")+1));
				
				if ((x).equals(AccountLogin.user + ".txt")) {
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
			
			else
			{
				JOptionPane.showMessageDialog(frmGrades, "You cannot view this grade!");
			}
			
			
		}});
		btnNewButton.setBounds(15, 11, 139, 24);
		frmGrades.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmGrades.dispose();
				StudentAccount.main(null);
			}
		});
		btnBack.setBounds(298, 11, 115, 24);
		frmGrades.getContentPane().add(btnBack);
		
	}
}
