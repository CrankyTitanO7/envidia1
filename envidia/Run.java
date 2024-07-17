// run script

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Run {
    // call an instance of each script
    public static Network nn = new Network();
    public static Input innie = new Input();
    public static Convoman civila = new Convoman();

    // a function that awakens the network
    public static void thinkonce(int[] shapea) {
        int[] mellon = shapea;
        nn.retrieveShape(mellon);
        nn.awake();
    }

    // here is the realll dealll. this means thoughts and actions. i hope.
    public static void real(Scanner sc, int mode) throws IOException {
        System.out.println("boot sequence: wizard says: type params");

        //questions
        int[] shapes = innie.interrogate(sc);

        System.out.println("All parameters generated. Begin booting sequence...");

        // begin a thought
        thinkonce(shapes);

        // get human response
        String responsea;
        responsea = innie.getme(sc);

        float[] call = innie.convmode(responsea, 1);
        float[][][][] echo = nn.brain(call);
        float[] irlecho = echo[0][0][0];

        

        if (mode == 0) {
            innie.decode(irlecho, mode, "0", 0);
        } else if (mode == 1){
            // how long is the file
            String filename = "envidia/memory/tokens.txt";
            int lines = 0;
            BufferedReader br = new BufferedReader(new FileReader(filename));


            while (br.readLine() != null) {
                lines++;
            }

            br.close();

            //input the ai outputs, the mode (tokenizer mode), name of tokenizer storage, and # of lines
            innie.decode(irlecho, mode, filename, lines);
        }
    }


    // the loop, not the starter prompt and stuffs
    public static void convo(Scanner sc){
        String responseb;

        responseb = innie.getme(sc);

        float[] call = innie.convmode(responseb, 1);
        String echo = civila.conversate(call);

        System.out.print(echo);
    }
    
    // the actual the moment you all have been waiting for... the running script!
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        
        real(sc, 0);
        while (innie.getme(sc) != "you know what to do"){
            convo(sc);
        }
        System.out.println("very well. see you around... \n");

        //end a thought

        sc.close();
    }
}
