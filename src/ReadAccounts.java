import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class ReadAccounts {
// this reads accountInformation.txt file
	Scanner readFile;
	static String current, ln, fn, bal, atmStatus;
	
	public void openFile()
	{
		try {
			readFile = new Scanner(new File("AccountInformation.txt"));
		}
		catch(FileNotFoundException e) {
			System.out.println("File cannot be found or opened!");
			System.exit(1);
		}
	}
	
	public static int getBalance(String accountNumber)
    {
		try
		{
			@SuppressWarnings("resource")
			Scanner keyb = new Scanner(new File("AccountInformation.txt"));
			
			ArrayList<String> lines = new ArrayList<String>();
			while (keyb.hasNextLine())
			{
				lines.add(keyb.nextLine());
			}
			
			for (int i = 0; i < lines.size();i+=5){
				if (lines.get(i).equals(accountNumber))
				{
					return Integer.parseInt(lines.get(i+3));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
    }
	
	public void read_file()
	{
		
		while(readFile.hasNext()){
			current = readFile.nextLine();
			ln = readFile.nextLine(); 
			fn = readFile.nextLine();
			bal = readFile.nextLine();
			atmStatus = readFile.nextLine();
		}	
	}
	
	public void read_file(String accountNumber)
	{
		ArrayList<String> lines = new ArrayList<String>();
		while (readFile.hasNextLine())
			lines.add(readFile.nextLine());
		
		for (int i = 0; i < lines.size(); i += 5)
		{
			if (lines.get(i).equals(accountNumber))
			{
				current = lines.get(i);
				ln = lines.get(i+1);
				fn = lines.get(i+2);
				bal = lines.get(i+3);
				atmStatus = lines.get(i+4);
				break;
			}
		}
	}
	
	public void close_file()
	{
		readFile.close();
	}
	
	
}

