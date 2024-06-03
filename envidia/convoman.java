public class convoman {
    public static Network nn = new Network();
    public static Network nna = new Network();
    public static fileplay f = new fileplay();

    public String conversate(float[] input) {
        String[] tops = f.read("topics.txt");
        String[] phrases = f.read("phrases.txt");

        String output = "I don't understand what you mean. Try again.";

        //determine topic of convo

        int[] shape = {input.length, 2, 2, phrases.length};
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
