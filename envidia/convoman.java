public class Convoman {
    public static Network nn = new Network();
    public static Network nna = new Network();
    public static fileplay f = new fileplay();

    public String conversate(float[] input) {
        String[] tops = f.read("memory\\topics.txt");
        int longestphraselength = 100; // DELETE THIS LATER: when you actually make phrase files, iterate over each and find the length of them all. 
        //See how long the longest one is.

        String output = "I don't understand what you mean. Try again.";

        //determine topic of convo

        int[] shape = {input.length, 2, 2, longestphraselength};
        nn.retrieveShape(shape);
        nn.awake();

        float[][][][] topic = nn.brain(input);
        float[] irltopic = topic[0][0][0];

        //choose best topic

        int choice = 0;
        float largest = -1;

        for (int i = 0; i < topic.length; i++) {
            if (irltopic[i] > largest) {
                choice = i;
                largest = choice;
            }
        }

        String totalk = tops[choice];

                        //choose a phrase based on topic

        //determine which phrase file to open (no options yet)
        String[] phrases = f.read("memory\\phrases\\default.txt");
        if (totalk == "weather"){
            phrases = f.read("memory\\phrases\\weather.txt");
        }

        //awaken a new network to determine phrases
        int[] shapea = {input.length, 2, 2, phrases.length};
        nn.retrieveShape(shapea);
        nn.awake();

        //make a new thingy for the purpose of thingying (neural network awakens and the brain arises)
        float[][][][] phrasec = nn.brain(input);
        float[] irlphrasec = phrasec[0][0][0];

        // determine which conversation topic has been selected by the network
        choice = 0;
        largest = -1;

        for (int i = 0; i < phrases.length; i++) {
            if (irlphrasec[i] > largest) {
                choice = i;
                largest = choice;
            }
        }

        //cleanup
        String phrase = phrases[choice];

        output = phrase;

        return output;
    }
}
