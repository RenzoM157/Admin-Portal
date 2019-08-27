import java.util.List;
import java.util.stream.Collectors;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


//Replacing 
public class WriteAndUpdate {

	static void updateFile(String fileName, String current, String update) {
        StringBuilder result = new StringBuilder();
        FileWriter fw;
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(fileName));
            
            for(String line: lines) {
                line = line.replace(current, update);
                result.append(line + "\r\n");
            }

            fw = new FileWriter(fileName);
            fw.write(result.toString());
            fw.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }
	
	
	
    
	static void removeLine(String fileName,String lineContent) throws IOException
	{
	    File file = new File(fileName);
	    List<String> out = Files.lines(file.toPath())
	                        .filter(line -> !line.contains(lineContent))
	                        .collect(Collectors.toList());
	    Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
	}

	static void updateBalance(String fileName, String accountNumber, String update) {
        StringBuilder result = new StringBuilder();
        FileWriter fw;
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(fileName));
            
            for (int i = 0 ; i < lines.size(); i += 5)
            {
            	result.append(lines.get(i)+"\r\n");
            	result.append(lines.get(i+1)+"\r\n");
            	result.append(lines.get(i+2)+"\r\n");
            	
            	if (lines.get(i).equals(accountNumber))
            	{
            		result.append(update+"\r\n");
            	}
            	else
            		result.append(lines.get(i+3)+"\r\n");
            	
            	result.append(lines.get(i+4)+"\r\n");
            }

            fw = new FileWriter(fileName);
            fw.write(result.toString());
            fw.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }
	
}
