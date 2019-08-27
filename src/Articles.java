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
import java.awt.event.ActionEvent;

public class Articles {

	private JFrame frmArticles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Articles window = new Articles();
					window.frmArticles.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Articles() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmArticles = new JFrame();
		frmArticles.setTitle("Articles");
		frmArticles.setBounds(100, 100, 450, 300);
		frmArticles.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmArticles.getContentPane().setLayout(null);
		
		JTextArea jTextArea1 = new JTextArea();
		jTextArea1.setBounds(9, 11, 328, 197);
		frmArticles.getContentPane().add(jTextArea1);
		
		JScrollPane scrollBar = new JScrollPane(jTextArea1);
		scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		frmArticles.getContentPane().add(scrollBar);
		scrollBar.setBounds(13, 39, 413, 189);
		
		JButton btnNewButton = new JButton("Read Text");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileSystemView fsv = new DirectoryRestrictedFileSystemView(new File("Articles"));
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
		frmArticles.getContentPane().add(btnNewButton);
		

		JButton btnWriteText = new JButton("Write Text");
		btnWriteText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String fileName = JOptionPane.showInputDialog(null, "Please enter the name of the file you wish to save");
					FileWriter writer = new FileWriter("Articles\\"+ fileName +".txt");
					BufferedWriter bw = new BufferedWriter (writer);
					jTextArea1.write(bw);
					bw.close();
					jTextArea1.setText("");
					jTextArea1.requestFocus();
					
					frmArticles.dispose();
					
					ProfessorAccount.main(null);
				
			}
			catch(Exception e1) {
				JOptionPane.showMessageDialog(null, e1);
		    	}
	    	}
			
		});
		btnWriteText.setBounds(154, 11, 115, 24);
		frmArticles.getContentPane().add(btnWriteText);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmArticles.dispose();
				ProfessorAccount.main(null);
			}
		});
		btnBack.setBounds(298, 11, 115, 24);
		frmArticles.getContentPane().add(btnBack);
	}
}
