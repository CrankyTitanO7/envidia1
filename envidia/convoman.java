public class convoman {
    public static Network nn = new Network();
    public static Network nna = new Network();
    public static fileplay f = new fileplay();

    public String conversate(float[] input) {
        String[] tops = f.read("topics.txt");
        int longestphraselength = 100; // DELETE THIS LATER: when you actually make phrase files, iterate over each and find the length of them all. 
        //See how long the longest one is.

        String output = "I don't understand what you mean. Try again.";

        //determine topic of convo

        int[] shape = {input.length, 2, 2, longestphraselength};
        nn.retrieveShape(shape);
        nn.awake();

        float[] topic = nn.brain(input);

        //choose best topic

        int choice = 0;
        float largest = -1;

        for (int i = 0; i < topic.length; i++) {
            if (topic[i] > largest) {
                choice = i;
                largest = choice;
            }
        }

        String totalk = tops[choice];

                        //choose a phrase based on topic

        //determine which phrase file to open (no options yet)
        String[] phrases = f.read("default.txt");
        if (totalk == "weather"){
            phrases = f.read("phrases.txt");
        }

        //awaken a new network to determine phrases
        int[] shapea = {input.length, 2, 2, phrases.length};
        nn.retrieveShape(shapea);
        nn.awake();

        float[] phrasec = nn.brain(input);

        choice = 0;
        largest = -1;

        for (int i = 0; i < phrases.length; i++) {
            if (phrasec[i] > largest) {
                choice = i;
                largest = choice;
            }
        }

        String phrase = phrases[choice];

        output = phrase;

        return output;
    }
}
