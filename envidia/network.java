// network script

public class Network {
    public int[] networkShape = {2, 4, 4, 2};
    public Layer[] layers;

    public void retrieveShape (int[] shapedesc) {
        if (shapedesc.length > 3) {
            int[] nuwaits = shapedesc;
            networkShape = nuwaits;
            
        } else {
            throw new IllegalArgumentException("Shape description must have 4+ elements.");
        }
    }

    public class Layer {
        public float[][] weightsArray;
        public float[] biasesArray;
        public float[] nodesArray;

        private int n_nodes;
        private int n_inputs;

        public Layer(int n_inputs, int n_nodes) {
            this.n_nodes = n_nodes;
            this.n_inputs = n_inputs;

            weightsArray = new float[n_nodes][n_inputs];
            biasesArray = new float[n_nodes];
            nodesArray = new float[n_nodes];
        }

        public void forward(float[] inputsArray) {
            nodesArray = new float[n_nodes]; 

            for(int i = 0; i < n_nodes; i++) {
                // sum of weights times inputs
                for(int j = 0; j < n_inputs; j++) {
                    nodesArray[i] += weightsArray[i][j] * inputsArray[j];
                }

                // add biases
                nodesArray[i] += biasesArray[i];
            }
        }

        public void activation() {
            for(int i = 0; i < n_nodes; i++) {
                if(nodesArray[i] < 0) {
                    nodesArray[i] = 0;
                }
            }
        }
    }

    public void introduce() {
        System.out.println("Hello, my name is EnVidia!");
    }

    public void awake() {
        layers = new Layer[networkShape.length - 1];
        for(int i = 0; i < layers.length; i++) {
            layers[i] = new Layer(networkShape[i], networkShape[i + 1]);
        }
        introduce();
    }

    public float[][][][] brain(float[] inputs) {
        // Determine the size of the final output layer
        int finalLayerSize = layers[layers.length - 1].nodesArray.length;
        int finalLayerSizeA = layers[layers.length - 1].weightsArray.length;
        // Initialize the output array with the appropriate size

        float[][][][] output = new float[layers.length][1][finalLayerSize][finalLayerSizeA];
        /*
        [0][0][0] = output
        [layers] [1][0] = biases
        [layers] [2][etc] = weights
        */


        // Forward propagate the input through the network

        for(int i = 0; i < layers.length; i++) {
            if(i == 0) {
                layers[i].forward(inputs);
                layers[i].activation();
            } else if(i == layers.length - 1) {
                layers[i].forward(layers[i - 1].nodesArray);
            } else {
                layers[i].forward(layers[i - 1].nodesArray);
                layers[i].activation();
            }
        }
        output[0][0][0] =  layers[layers.length - 1].nodesArray;

        for (int i = 0; i < layers.length-1; i++){
            output[i][1][0] = layers[i].biasesArray;
        }

        for (int i = 0; i < layers.length-1; i++){
            output[i][2] = layers[i].weightsArray;
        }

        return output;
    }
}

