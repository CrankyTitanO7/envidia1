import java.io.IOException;
import java.util.Scanner;
// import java.io.*;
// import java.util.*;

public class Input {

    // a short function to get the next line entered in the terminal
    public String getme(Scanner sc) 
    {
        String name = sc.nextLine();
        return name;
    }

    // decide to tokenize
    //to tokenize or not to tokenize: that is the question, bruh
    public float[] convmode(String text, int mode) 
    {
        float[] contin = {2f, 2f, 2f, 2f, 2f};

        try 
        {
            if (mode == 1)
            {
                return convertASCII(text);
            } else if (mode == 2) 
            {
                tokenize(text);
                contin = convmode_assister();
                return contin;
            } else 
            {
                return contin;
            }
        } catch (Exception e) 
        {
            System.out.println("error detected in convmode() of Input.java!");
            return contin;
        }
    }

    public float[] convmode_assister(){
        String love_yourself = "the past is never dead; it's not even past";
        float[] cont = new float[love_yourself.length()];

        for (int i = 0; i < love_yourself.length(); i++){
            char character = love_yourself.charAt(i);    
            float ascii = (float) character;
            cont[i] = ascii;
        }

        return cont;
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

    public String decode(float[] ins, int mode, String floc, int lent) throws IOException {
        String rest = "something went wrong :( (there will be blood)";
        if (mode == 0){
            // for things in the output array, convert each ASCII to a letter
            for (float ping : ins) {
                System.out.print(Float.toString(ping));
            }
        } else if (mode == 1){
            detokenize(floc, lent);
        }
        return rest;
    }
    
    public void tokenize(String tokenee) throws IOException {
        String[] command = {"python", "envidia/tokenizer.py", "tokengen", tokenee, "0"};
        Process p = Runtime.getRuntime().exec(command);
        System.out.println("tokenization complete!");
    }

    public void detokenize(String filelocation, int length) throws IOException{
        String[] command = {"python", "envidia/tokenizer.py", "decode", filelocation, String.valueOf(length)};;
        Process p = Runtime.getRuntime().exec( command );
        System.out.println("detokenization complete!");
    }


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
