from tokenizers import ByteLevelBPETokenizer

# Initialize a tokenizer
tokenizer = ByteLevelBPETokenizer()

# Train the tokenizer on your dataset
tokenizer.train(files=["path/to/your/dataset.txt"], vocab_size=30_000, min_frequency=2)

# Save the tokenizer
tokenizer.save_model("path/to/save")

# Load the tokenizer
tokenizer = ByteLevelBPETokenizer(
    "path/to/save/vocab.json",
    "path/to/save/merges.txt",
)

# Tokenize some text and save the tokens to a file
text = "Here is some text to tokenize"
encoded = tokenizer.encode(text)

# Save tokens and their IDs to a text file
with open("tokens.txt", "w") as f:
    for token, token_id in zip(encoded.tokens, encoded.ids):
        f.write(f"{token}\t{token_id}\n")
