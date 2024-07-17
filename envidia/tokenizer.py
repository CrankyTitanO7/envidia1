from transformers import AutoTokenizer
import sys

def tokengen (words, pad, length):

    tokenizer = AutoTokenizer.from_pretrained("bert-base-cased")

    sequence = words
    tokens = tokenizer.tokenize(sequence)

    print(tokens)

    tokenizer.save_pretrained("envidia\tokens")

    ids = tokenizer.convert_tokens_to_ids(tokens)

    lens = len(ids)

    print(ids)

    model_inputs = tokenizer(sequence)

    if pad > 0 :

        if length == "longest":
            # Will pad the sequences up to the maximum sequence length
            model_inputs = tokenizer(sequence, padding="longest")
        elif pad == 1 :
            # Will pad the sequences up to the model max length
            # (512 for BERT or DistilBERT)
            model_inputs = tokenizer(sequence, padding="max_length")
        elif pad == 2 :
            # Will pad the sequences up to the specified max length
            model_inputs = tokenizer(sequence, padding="max_length", max_length=length)
    print(model_inputs)
    return model_inputs

    

def decode (array_of_inputs, fname, lenth):
    array_of_inputs = openfile(fname, lenth)

    tokenizer = AutoTokenizer.from_pretrained("bert-base-cased")

    decoded_string = tokenizer.decode(array_of_inputs)
    print(decoded_string)

    return (decoded_string)

def openfile(filename, length):
    returnlist = []
    f = open(filename, "r")
    for i in range (length):
        returnlist.append(f.readline())
    return returnlist
    

if __name__ == '__main__':
    globals()[sys.argv[1]](sys.argv[2])(sys.argv[3])(sys.argv[4])