using System.Collections;
using System.Collections.Generic;

public class _Network
{
    public int[] networkShape = {2, 4, 4, 2};
    public Layer[] layers;


    public class Layer
    {

        public float[,] weightsArray;
        public float[] biassesArray;
        public float[] nodesArray;

        private int n_nodes;
        private int n_inputs;

        public Layer(int n_inputs, int n_nodes)
        {
            this.n_nodes = n_nodes;
            this.n_inputs = n_inputs;

            weightsArray = new float[n_nodes, n_inputs];
            biassesArray = new float[n_nodes];
            nodesArray = new float[n_nodes];
        }

        public void Forward(float[] inputsArray)
        {
            nodesArray = new float[n_nodes]; 

            for(int i = 0; i < n_nodes; i++)
            {
                // sum of weights times inputs
                for(int j = 0; j < n_inputs; j++)
                {
                    nodesArray[i] += weightsArray[i, j] * inputsArray[j];
                }

                // add biases
                nodesArray[i] += biassesArray[i];
            }
        }

        public void Activation()
        {
            for(int i = 0; i < n_nodes; i++)
            {
                if(nodesArray[i] < 0)
                {
                    nodesArray[i] = 0;
                }
            }
        }
    }

    public void Awake()
    {
        layers = new Layer[networkShape.Length - 1];
        for(int i = 0; i < layers.Length; i++)
        {
            layers[i] = new Layer(networkShape[i], networkShape[i + 1]);
        }
    }

    public float[] Brain(float[] inputs)
    {
        
        for(int i = 0; i < layers.Length; i++)
        {
            if(i == 0)
            {
                layers[i].Forward(inputs);
                layers[i].Activation();
            }
            else if(i == layers.Length - 1)
            {
                layers[i].Forward(layers[i - 1].nodesArray);
            }
            else
            {
                layers[i].Forward(layers[i - 1].nodesArray);
                layers[i].Activation();
            }

        }

        return(layers[layers.Length - 1].nodesArray);
    }
}
