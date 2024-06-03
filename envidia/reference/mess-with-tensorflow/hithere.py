import tensorflow as tf

mnist = tf.keras.datasets.mnist

(x_train, y_train), (x_test, y_test) = mnist.load_data()
x_train, x_test = x_train / 255.0, x_test / 255.0

model = tf.keras.models.Sequential([
  tf.keras.layers.Flatten(input_shape=(28, 28)),
  tf.keras.layers.Dense(128, activation='relu'),
  tf.keras.layers.Dropout(0.2),
  tf.keras.layers.Dense(10)
])

#make some raw numbers that are NOT normalized
predictions = model(x_train[:1]).numpy()
print(predictions)

#each of those becomes a probability
tf.nn.softmax(predictions).numpy()
print(predictions)

#deterimine loss
loss_fn = tf.keras.losses.SparseCategoricalCrossentropy(from_logits=True)
    #The loss function takes a vector of ground truth values and a vector of logits and returns a scalar loss for each example. 
    #This loss is equal to the negative log probability of the true class: The loss is zero if the model is sure of the correct class.

loss_fn(y_train[:1], predictions).numpy()

model.compile(optimizer='adam',
              loss=loss_fn,
              metrics=['accuracy'])

model.fit(x_train, y_train, epochs=5)