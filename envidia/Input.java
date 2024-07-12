import java.util.Scanner;

public class Input {

    // a short function to get the next line entered in the terminal
    public String getme(Scanner sc) {
        String name = sc.nextLine();
        return name;
    }

    // decide to tokenize
    //to tokenize or not to tokenize: that is the question, bruh
    public float[] convmode(String text, int mode) {
        if (mode == 1){
            return convertASCII(text)
        } else if (mode == 2) {
            tokenize(text)
            return [1f, 2f, 3f, 4f, 6f]
        } else {
            return [2f, 2f, 2f, 2f, 2f]
        }
    }

    // converts to ASCII from LETTERS (english)
    public float[] convertASCII(String text) {
        String input = text;
        int len = input.length();
        float[] returnme = new float[len];

        if (len < 1) {
            return returnme;
        }

        for (int i = 0; i < len; i++){
            returnme[i] = (float) input.charAt(i);        
        }
        return returnme;
        
    }

    // PROBLEM SPOT ------- tokenizers ---- must invoke a python file to tokenize the text, then detokenize again. PROBLEM: Runtime is DEPRICATED :((
    
    // public void tokenize(String tokenee){
    //     String param;
    //     String command = "python envidia/tokenizer.py tokengen " + tokenee + " 0";
    //     Process p = Runtime.getRuntime().exec( command + param );
    // }

    // public void detokenize(String[] tokenids){
    //     String command = "python envidia/tokenizer.py decode" + tokenids;
    //     Process p = Runtime.getRuntime().exec( command + param );
    // }


    // here are the questions asked at the very beginning, so that the network is initiated and such
    public int[] interrogate(Scanner sc){
        System.out.println("-- begin interrogation --");

        String response;

        System.out.println("How many layers?");
        response = getme(sc);
        int[] shape = new int[Integer.parseInt(response)];

        System.out.println("How many inputs?");
        response = getme(sc);
        shape[0] = Integer.valueOf(response);

        System.out.println("How many outputs?");
        response = getme(sc);
        shape[shape.length - 1] = Integer.valueOf(response);

        System.out.println("Size of middle layers?");
        response = getme(sc);
        int arbitrate = Integer.valueOf(response);

        for (int i = 1; i < shape.length-1; i++) {
            shape[i] = arbitrate;
        }


        for (int laya : shape) {
            System.out.println("params stored: " + Integer.toString(laya));
        }
        
        System.out.println("-- end interrogation --");
        return shape;
    }
}
