from transformers import GPT2LMHeadModel, GPT2Tokenizer

# Load the fine-tuned model and tokenizer
model = GPT2LMHeadModel.from_pretrained('./my_model')
tokenizer = GPT2Tokenizer.from_pretrained('./my_model')

# Encode input text
input_text = "Once upon a time"
input_ids = tokenizer.encode(input_text, return_tensors='pt')

# Create an attention mask (1 for actual tokens, 0 for padding tokens)
attention_mask = input_ids.ne(tokenizer.pad_token_id).long()

# Generate text
output = model.generate(input_ids, attention_mask=attention_mask, max_length=100, num_return_sequences=1)

# Decode the generated text
generated_text = tokenizer.decode(output[0], skip_special_tokens=True)
print(generated_text)
