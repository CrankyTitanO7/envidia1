// run script

public class Run {
    public static Network nn = new Network();
    public static Input innie = new Input();
    
    public static void main(String[] args) {
        String response;

        nn.awake();
        response = innie.getme();

        float[] call = innie.convert(response);
        float[] echo = nn.brain(call);

        for (float ping : echo) {
            System.out.println(Float. toString(ping));
        }
    }
}
