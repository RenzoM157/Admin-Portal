import java.io.*; 
import java.util.HashSet; 
  
public class FileOperation 
{ 
    public static void main(String[] args) throws IOException  
    { 
        // PrintWriter object for output.txt 
        PrintWriter pw = new PrintWriter("output.txt"); 
          
        // BufferedReader object for delete.txt 
        BufferedReader br2 = new BufferedReader(new FileReader("delete.txt")); 
          
        String line2 = br2.readLine(); 
          
        // hashset for storing lines of delete.txt 
        HashSet<String> hs = new HashSet<String>(); 
          
        // loop for each line of delete.txt 
        while(line2 != null) 
        { 
            hs.add(line2); 
            line2 = br2.readLine(); 
        } 
                      
        // BufferedReader object for input.txt 
        BufferedReader br1 = new BufferedReader(new FileReader("input.txt")); 
          
        String line1 = br1.readLine(); 
          
        // loop for each line of input.txt 
        while(line1 != null) 
        { 
            // if line is not present in delete.txt 
            // write it to output.txt 
            if(!hs.contains(line1)) 
                pw.println(line1); 
              
            line1 = br1.readLine(); 
        } 
          
        pw.flush(); 
          
        // closing resources 
        br1.close(); 
        br2.close(); 
        pw.close(); 
          
        System.out.println("File operation performed successfully"); 
    } 
} 