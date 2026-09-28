# AI/ML Fundamentals — Interview Revision Guide

A simple, interview-ready guide for core AI/ML and Generative AI concepts.

---

## 1. AI vs ML vs Deep Learning

```text
Artificial Intelligence (AI)
        ↓
Machine Learning (ML)
        ↓
Deep Learning (DL)
```

| Term | Simple meaning | Example |
|---|---|---|
| **Artificial Intelligence (AI)** | Making computers perform tasks that appear intelligent, such as reasoning, planning, perception, or language use | A chess program, route planner, voice assistant |
| **Machine Learning (ML)** | A part of AI where models learn patterns from data instead of being explicitly given every rule | Learning to identify spam from past emails |
| **Deep Learning (DL)** | A part of ML that uses neural networks with many layers; useful for text, images, speech, and large datasets | Face recognition, speech-to-text, LLMs |

### Interview answer

> AI is the broad field of building intelligent systems. Machine learning is a subset of AI in which models learn from data. Deep learning is a subset of ML that uses multi-layer neural networks and is especially effective for images, audio, and text.

### Easy example

- **Rule-based AI:** “If an email contains `free money`, mark it as spam.”
- **ML:** Train using thousands of emails already labeled spam or not spam.
- **Deep Learning:** Use a neural network to learn complex patterns from very large amounts of text, image, or audio data.

---

## 2. Supervised vs Unsupervised Learning

| Type | Training data | Goal | Typical tasks | Example |
|---|---|---|---|---|
| **Supervised learning** | Labeled data: input + correct answer | Predict correct answers for new data | Classification, regression | Past houses with features and prices |
| **Unsupervised learning** | Unlabeled data: input only | Find hidden patterns or structure | Clustering, dimensionality reduction | Group customers based on behavior |

### Supervised learning

The dataset contains inputs and their correct outputs.

```text
Email text → Spam
Email text → Not spam
Email text → Spam
```

The model learns from these examples and predicts the output for new emails.

#### Main supervised tasks

- **Classification:** Predicts a category.
  - Spam / Not spam
  - Fraud / Not fraud
  - Cat / Dog / Bird
  - Disease / No disease

- **Regression:** Predicts a continuous number.
  - House price
  - Temperature
  - Delivery time
  - Monthly sales

### Unsupervised learning

The dataset has inputs but no correct labels. The model tries to find useful patterns.

- **Clustering:** Groups similar data points.
  - Example: Group customers into budget, frequent, and premium buyers.

- **Dimensionality reduction:** Reduces the number of features while keeping important information.
  - Example: Reduce 1,000 customer features to 20 features for visualization or faster training.
  - Common example: **PCA** (Principal Component Analysis).

### Interview answer

> In supervised learning, the model is trained using labeled examples, such as emails already marked spam or not spam. In unsupervised learning, there are no labels, so the model discovers patterns itself, such as customer groups through clustering.

---

## 3. Classification vs Regression

Ask one question:

> Is the output a category or a number?

| Task | Output | Example | Common metrics |
|---|---|---|---|
| **Classification** | Category / class | Spam or not spam | Accuracy, precision, recall, F1-score |
| **Regression** | Continuous number | Predict a house price | MAE, MSE, RMSE, R² |

### Classification example

```text
Input:  "You won a free iPhone. Click now!"
Output: Spam
```

### Regression example

```text
Input:  House area, bedrooms, location, age
Output: ₹62,00,000
```

### Quick interview rule

> If the answer is a category, it is classification. If the answer is a numeric quantity, it is regression.

---

## 4. Underfitting, Good Fit, and Overfitting

```text
Underfitting       → Model is too simple
Good fit           → Learns useful general patterns
Overfitting        → Memorizes training data or noise
```

| Situation | Training performance | Validation/test performance | Meaning |
|---|---:|---:|---|
| **Underfitting** | Poor | Poor | Model has not learned enough |
| **Good fit** | Good | Good and close to training performance | Model generalizes well |
| **Overfitting** | Very good | Much worse than training performance | Model learned noise or training-specific details |

### Underfitting

The model is too simple to learn the real pattern.

Example: Predicting house prices only from area, while ignoring location, age, neighborhood, and amenities.

**Signs**

- High training error
- High validation/test error
- Poor results even on training data

**Possible fixes**

- Use better features
- Use a more capable model
- Train longer when appropriate
- Reduce excessive regularization
- Improve data quality

### Good fit

The model learns useful patterns and performs similarly on training and unseen data.

Example: It learns that larger homes in expensive areas usually cost more, without memorizing every training house.

### Overfitting

The model performs extremely well on training data but poorly on new data. It learns noise or memorizes examples instead of learning general rules.

**Easy analogy:** A student memorizes old exam questions but cannot solve changed questions.

### How do you detect overfitting?

Compare training and validation/test performance.

```text
Training accuracy:   99%
Validation accuracy: 72%
```

A large gap suggests overfitting.

For regression:

```text
Training error:   Low
Validation error: Much higher
```

Also inspect learning curves:

- Training loss keeps decreasing.
- Validation loss starts increasing.
- This indicates the model is starting to overfit.

### How do you reduce overfitting?

- **More data:** More diverse examples help the model learn general patterns.
- **Regularization:** Penalizes unnecessary model complexity or extreme weights.
- **Cross-validation:** Tests the model across multiple data splits.
- **Dropout:** During neural-network training, randomly disables some neurons.
- **Early stopping:** Stop when validation performance stops improving.
- **Simpler model:** Reduce tree depth, neural-network size, polynomial degree, or features.
- **Data augmentation:** Create meaningful variations of images or audio data.

### Interview answer

> I detect overfitting by comparing training and validation performance. If training performance is much better than validation performance, or validation loss rises while training loss falls, the model is overfitting. I can reduce it through more diverse data, regularization, cross-validation, dropout, early stopping, data augmentation, or a simpler model.

---

## 5. Confusion Matrix

For binary classification, assume the positive class is **has disease**.

| Actual / Predicted | Predicted disease | Predicted no disease |
|---|---:|---:|
| Actually has disease | True Positive (TP) | False Negative (FN) |
| Actually has no disease | False Positive (FP) | True Negative (TN) |

- **True positive:** Person has disease; model says disease.
- **True negative:** Person does not have disease; model says no disease.
- **False positive:** Person does not have disease; model incorrectly says disease.
- **False negative:** Person has disease; model incorrectly says no disease.

---

## 6. ML Metrics

### Accuracy

\[
\text{Accuracy} = \frac{TP + TN}{TP + TN + FP + FN}
\]

**Question answered:** Out of all predictions, how many were correct?

Useful when classes are balanced and false positives and false negatives have similar cost.

**Problem with accuracy:** It can be misleading for imbalanced data.

Example: If 99 out of 100 transactions are legitimate, a model that always predicts “legitimate” gets 99% accuracy but catches no fraud.

### Precision

\[
\text{Precision} = \frac{TP}{TP + FP}
\]

**Question answered:** When the model predicts positive, how often is it correct?

Use precision when **false positives are costly**.

**Example: Spam detection**

A false positive means an important genuine email is incorrectly sent to spam. High precision means emails marked spam are usually truly spam.

### Recall

\[
\text{Recall} = \frac{TP}{TP + FN}
\]

**Question answered:** Out of all actual positive cases, how many did the model identify?

Use recall when **false negatives are costly**.

**Example: Disease detection**

A false negative means a sick patient is incorrectly told they are healthy.

### Why recall matters in disease detection

Missing a real disease case can delay treatment and cause serious harm. So a screening system often aims for high recall, even if it creates some false positives.

Those false positives can be checked using a second, more accurate medical test.

### Precision vs Recall

| Question | Precision | Recall |
|---|---|---|
| Focus | Correctness of positive predictions | Coverage of actual positive cases |
| Formula | TP / (TP + FP) | TP / (TP + FN) |
| Important when | False positives are costly | False negatives are costly |
| Example | Avoid putting genuine emails in spam | Catch as many disease cases as possible |

### Threshold trade-off

- **Lower threshold:** More cases are predicted positive → recall usually rises, precision may fall.
- **Higher threshold:** Fewer cases are predicted positive → precision may rise, recall may fall.

### F1-score

\[
F1 = 2 \times \frac{\text{Precision} \times \text{Recall}}{\text{Precision} + \text{Recall}}
\]

F1-score is the harmonic mean of precision and recall.

Use it when:

- You need a balance between precision and recall.
- The dataset is imbalanced.
- Both false positives and false negatives matter.

If either precision or recall is low, F1-score is also low.

---

## 7. Generative AI Basics

### What is an LLM?

**LLM** means **Large Language Model**.

It is an AI model trained on very large amounts of text to understand and generate language. At a basic level, it predicts likely next tokens from the context it receives.

```text
Prompt: "The capital of India is"
Likely next tokens: "New Delhi"
```

LLMs can:

- Answer questions
- Summarize text
- Translate languages
- Write code
- Generate content
- Extract information
- Hold conversations

### Interview answer

> An LLM is a large language model trained on massive text data to understand and generate human-like language. At a basic level, it generates text by predicting the next token based on the context it receives.

### What is a token?

A **token** is a small unit of text processed by an LLM.

A token can be:

- A whole common word
- Part of a long word
- A punctuation mark
- A number
- Sometimes whitespace-related text

For example, a long word may be split into multiple tokens depending on the tokenizer.

**Important:** Model limits and API costs are commonly measured in tokens, not only words or characters.

### What is an embedding?

An **embedding** is a vector: a list of numbers that represents the meaning of text, images, audio, or other data.

```text
Similar meaning → Embeddings close together
Different meaning → Embeddings farther apart
```

Example:

```text
"How do I reset my password?"
"I forgot my login password."
```

These sentences have similar meaning, so their embeddings should be close together.

**Embeddings are used for:**

- Semantic search
- Document retrieval
- Recommendations
- Clustering
- Duplicate detection
- RAG systems

### What is a transformer?

A **transformer** is the neural-network architecture used by many modern LLMs.

Its main idea is **attention**, especially **self-attention**.

Attention lets the model determine which tokens are important to understand another token, even if the related words are far apart.

Example:

```text
"The animal did not cross the road because it was tired."
```

The word `it` refers to `the animal`, not `the road`. Attention helps identify this relationship.

### Interview answer

> Transformers process text using attention. Attention helps the model decide which tokens are most relevant to each other, even across long distances in a sentence. This ability to capture relationships in context is why transformers are powerful for language tasks.

---

## 8. RAG

**RAG** means **Retrieval-Augmented Generation**.

It combines an LLM with an external knowledge source, such as documents, PDFs, FAQs, company policies, or a database.

```text
User question
      ↓
Convert question into an embedding
      ↓
Retrieve relevant document chunks
      ↓
Provide the retrieved context to the LLM
      ↓
LLM generates a grounded answer
```

### Example

A company has internal leave-policy documents.

Instead of expecting the LLM to memorize every policy, a RAG system retrieves the relevant policy section and gives it to the LLM before it answers the employee’s question.

### Typical RAG pipeline

1. Collect documents: PDFs, FAQs, web pages, databases, etc.
2. Split documents into smaller chunks.
3. Create embeddings for chunks.
4. Store embeddings in a vector database or search index.
5. Convert the user question into an embedding.
6. Retrieve the most relevant chunks.
7. Send the question and retrieved context to the LLM.
8. Generate a grounded answer, ideally with citations.

### Interview answer

> RAG retrieves relevant external information before generation. The retrieved content is added to the LLM prompt as context, allowing the model to answer based on current, private, or domain-specific documents instead of only its internal training knowledge.

---

## 9. RAG vs Fine-tuning

| Aspect | RAG | Fine-tuning |
|---|---|---|
| Main purpose | Give relevant knowledge at query time | Change model behavior through extra training |
| Where knowledge lives | External documents, database, vector store | Partly encoded in model weights |
| Updating information | Easy: update documents and re-index | Requires training again |
| Best for | Frequently changing or private knowledge | Tone, formatting, repeated task patterns |
| Example | Answer from current company policies | Train model to produce support-ticket JSON |
| Citations | Can cite retrieved sources | Usually cannot identify which training example produced the answer |

### Simple difference

- **RAG:** “Here are the relevant documents. Answer from them.”
- **Fine-tuning:** “Learn this preferred style, format, or task behavior.”

### Interview answer

> RAG provides external knowledge at inference time by retrieving relevant documents. Fine-tuning changes the model itself using additional training examples. I would use RAG for current company policies or documentation, and fine-tuning for consistent style, specific formats, or domain-specific behavior.

You can also combine them: fine-tune for behavior and use RAG for current factual knowledge.

---

## 10. AI Hallucinations

A **hallucination** is when an AI gives information that sounds believable but is false, unsupported, or invented.

### Examples

- Inventing a research-paper citation
- Claiming a product has a feature it does not have
- Giving a made-up company policy
- Producing code that calls a function that does not exist

Hallucinations are risky because the answer may sound confident and fluent even when wrong.

### How to reduce hallucinations

- **Use RAG / grounding:** Retrieve reliable documents and give them to the model.
- **Use trusted source data:** Poor documents create poor answers.
- **Improve retrieval quality:** Use good chunking, reranking, metadata filters, and relevant search.
- **Constrain the prompt:** Tell the model to answer only from provided context.
- **Allow abstention:** Tell it to say “I don’t know” if the answer is not present in the context.
- **Require citations:** Make responses easier to verify.
- **Use lower temperature when appropriate:** This often makes outputs more consistent, but does not guarantee factual accuracy.
- **Validate outputs:** Check JSON schemas, rules, database values, calculations, and allowed formats.
- **Use human review for high-stakes tasks:** Important for medical, legal, financial, safety, and production-critical decisions.
- **Evaluate regularly:** Test questions with missing, conflicting, and outdated information.

### Interview answer

> An AI hallucination is a confident but incorrect or unsupported response produced by a model. To reduce hallucinations, I would ground the model using RAG and reliable sources, improve retrieval quality, ask the model to say when information is unavailable, include citations, validate outputs, and use human review for high-risk use cases.

---

## 11. Quick Interview Revision

- **AI vs ML vs DL:** AI is the broad field of intelligent systems; ML is AI that learns from data; DL is ML using multi-layer neural networks.
- **Supervised vs unsupervised:** Supervised learning uses labeled data to predict outputs. Unsupervised learning uses unlabeled data to discover patterns.
- **Classification vs regression:** Classification predicts categories, such as spam/not spam. Regression predicts continuous numbers, such as house price.
- **Overfitting:** A model does very well on training data but poorly on unseen data because it learned noise or memorized examples.
- **Detecting overfitting:** Compare training and validation performance. A large performance gap indicates overfitting.
- **Reducing overfitting:** More data, regularization, cross-validation, dropout, early stopping, data augmentation, and simpler models.
- **Precision:** Of cases predicted positive, how many were truly positive?
- **Recall:** Of all actual positive cases, how many did the model detect?
- **Recall in disease detection:** Missing a sick patient can be dangerous, so catching real cases is important even if some false positives occur.
- **LLM:** A model trained on huge amounts of text that understands and generates language, often by predicting the next token.
- **Token:** A small unit of text processed by an LLM.
- **Embedding:** A numeric vector that represents meaning; similar meanings have similar vectors.
- **Transformer:** A neural-network architecture using attention to understand relationships among tokens.
- **RAG:** Retrieve relevant information, supply it as context to an LLM, then generate a grounded answer.
- **RAG vs fine-tuning:** RAG provides current external knowledge; fine-tuning changes model behavior through extra training.
- **Hallucination:** A plausible but false or unsupported AI response.

---
