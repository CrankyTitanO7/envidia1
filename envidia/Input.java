import java.util.Scanner;

public class Input {

    public String getme() {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();

        sc.close();

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
}
