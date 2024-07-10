// run script

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
    public static void real(Scanner sc) {
        System.out.println("boot sequence: wizard says: type params");

        //questions
        int[] shapes = innie.interrogate(sc);

        System.out.println("All parameters generated. Begin booting sequence...");

        // begin a thought
        thinkonce(shapes);

        // get human response
        String responsea;
        responsea = innie.getme(sc);

        // convert, think, return values
        float[] call = innie.convert(responsea);
        float[][][][] echo = nn.brain(call);
        float[] irlecho = echo[0][0][0];

        // for things in the output array, convert each ASCII to a letter
        for (float ping : irlecho) {
            System.out.print(Float.toString(ping));
        }
    }

    // print the lil network's response
    public static void convo(Scanner sc){
        String responseb;

        responseb = innie.getme(sc);

        float[] call = innie.convert(responseb);
        String echo = civila.conversate(call);

        System.out.print(echo);
    }
    
    // the actual the moment you all have been waiting for... the running script!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        

        real(sc);
        convo(sc);

        //end a thought





        sc.close();
    }
}
