// run script

import java.util.Scanner;

public class Run {
    public static Network nn = new Network();
    public static Input innie = new Input();

    public static void thinkonce(int[] shapea) {
        int[] mellon = shapea;
        nn.retrieveShape(mellon);
        nn.awake();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String response;

        System.out.println("boot sequence: wizard says: type params");

        //questions
        int[] shapes = innie.interrogate(sc);

        System.out.println("All parameters generated. Begin booting sequence...");

        // begin a thought
        thinkonce(shapes);
        
        response = innie.getme(sc);

        float[] call = innie.convert(response);
        float[] echo = nn.brain(call);

        for (float ping : echo) {
            System.out.print(Float.toString(ping));
        }
        //end a thought





        sc.close();
    }
}
