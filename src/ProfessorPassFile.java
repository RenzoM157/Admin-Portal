import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
public class ProfessorPassFile {
// this reads adminPassword.txt file
	Scanner readFile;
	public static HashMap<String, String> map = new HashMap<String, String>();
	static String account, password;
	
	public void openFile()
	{
		try {
			readFile = new Scanner(new FileInputStream("ProfessorPassword.txt"));
		}
		catch(FileNotFoundException e) {
			System.out.println("File cannot be found or opened!");
			System.exit(1);
		}
	}
	
	public void read_file()
	{
		while(readFile.hasNext()) {
			account = readFile.next();
			password = readFile.next();
			map.put(account, password);
		}
	}
	
	public void close_file()
	{
		readFile.close();
	}
	
	
}

