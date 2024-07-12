if __name__ == "__main__":
    from datasets import load_dataset
    from transformers import GPT2Tokenizer, DataCollatorForLanguageModeling, Trainer, TrainingArguments, GPT2LMHeadModel

    # Load a dataset
    dataset = load_dataset('wikitext', 'wikitext-2-raw-v1', split='train')

    # Initialize the tokenizer
    tokenizer = GPT2Tokenizer.from_pretrained('gpt2')

    tokenizer.pad_token = tokenizer.eos_token

    # Function to tokenize the dataset
    def tokenize_function(examples, tokenizer=tokenizer):
        return tokenizer(examples['text'], padding='max_length', truncation=True, max_length=128)

    # Tokenize the dataset
    tokenized_dataset = dataset.map(tokenize_function, batched=True, num_proc=4, remove_columns=["text"])

    # Initialize the Data Collator
    data_collator = DataCollatorForLanguageModeling(
        tokenizer=tokenizer,
        mlm=False,
    )

    # Initialize the model
    model = GPT2LMHeadModel.from_pretrained('gpt2')

    # Define training arguments
    training_args = TrainingArguments(
        output_dir='./results',
        overwrite_output_dir=True,
        num_train_epochs=3,
        per_device_train_batch_size=2,
        save_steps=10_000,
        save_total_limit=2,
        prediction_loss_only=True,
    )

    # Initialize the Trainer
    trainer = Trainer(
        model=model,
        args=training_args,
        data_collator=data_collator,
        train_dataset=tokenized_dataset,
    )

    # Train the model
    trainer.train()

   
