import java.util.Scanner;

public class Input {

    public String getme(Scanner sc) {
        String name = sc.nextLine();
        return name;
    }

    public float[] convert(String text) {
        String input = text;
        int len = input.length();
        float[] returnme = new float[len];

        if (len < 1) {
            return returnme;
        }

        for (int i = 0; i < len; i++){
            returnme[i] = (float) input.charAt(i);        }
        return returnme;
    }

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
