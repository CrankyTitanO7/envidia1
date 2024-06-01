import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class fileplay {

    public String[] read(String file){
        List<String> returnme = new ArrayList<String>();

        BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();

			while (line != null) {
				System.out.println(line);
                returnme.add(line);
				// read next line
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

        String[] arr = returnme.toArray(new String[0]);
        return arr;
    }

    

    public void write(String file, String[] words){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
            for (String word : words) {
                writer.write(word);
                writer.newLine();
            }
        }
            catch(IOException ex){
            ex.printStackTrace();
        }
    }
        
    public void del(String file){
        File f= new File(file);
        f.delete();
    }

    public void creat(String file){
        try {  
            File myObj = new File(file);  
            if (myObj.createNewFile()) {  
              System.out.println("File created: " + myObj.getName());  
            } else {  
              System.out.println("File already exists.");  
            }  
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();  
          }
    }
}
