import java.io.*;


public class play {
    public static void main(String[] args) throws FileNotFoundException {
        char a = 'a';
        int asc = a;

        System.out.println(asc);

        BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader("ha.txt"));
			String line = reader.readLine();

			while (line != null) {
				System.out.println(line);
				// read next line
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ha.txt", true))){
            writer.write("melelem");
            writer.newLine();
            writer.write("melelem2");
        }
            catch(IOException ex){
            ex.printStackTrace();
        }

        BufferedReader reader2;

		try {
			reader2 = new BufferedReader(new FileReader("ha.txt"));
			String line = reader2.readLine();

			while (line != null) {
				System.out.println(line);
				// read next line
				line = reader2.readLine();
			}

			reader2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

        File f= new File("ha.txt");
        f.delete();
        try {  
            File myObj = new File("ha.txt");  
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
