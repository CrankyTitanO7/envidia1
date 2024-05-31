public class network {
    class netobj{
        public int[] networkShape = {2, 4, 4, 2};
        public Layer[] layers;
    
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
    
        public void awake() {
            layers = new Layer[networkShape.length - 1];
            for(int i = 0; i < layers.length; i++) {
                layers[i] = new Layer(networkShape[i], networkShape[i + 1]);
            }
        }
    
        public float[] brain(float[] inputs) {
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
            return layers[layers.length - 1].nodesArray;
        }
    }
    
    public static void main(String[] args) {
        netobj.awake();
    }
}

