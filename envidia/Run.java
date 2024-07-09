// run script

import java.util.Scanner;

public class Run {
    public static Network nn = new Network();
    public static Input innie = new Input();
    public static Convoman civila = new convoman();

    public static void thinkonce(int[] shapea) {
        int[] mellon = shapea;
        nn.retrieveShape(mellon);
        nn.awake();
    }

    public static void real(Scanner sc) {
        System.out.println("boot sequence: wizard says: type params");

        //questions
        int[] shapes = innie.interrogate(sc);

        System.out.println("All parameters generated. Begin booting sequence...");

        // begin a thought
        thinkonce(shapes);

        String response;

        response = innie.getme(sc);

        float[] call = innie.convert(response);
        float[][][][] echo = nn.brain(call);
        float[] irlecho = echo[0][0][0];

        for (float ping : irlecho) {
            System.out.print(Float.toString(ping));
        }
    }

    public static void convo(Scanner sc){
        String response;

        response = innie.getme(sc);

        float[] call = innie.convert(response);
        String echo = civila.conversate(call);

        System.out.print(echo);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        

        real(sc);
        convo(sc);

        //end a thought





        sc.close();
    }
}
