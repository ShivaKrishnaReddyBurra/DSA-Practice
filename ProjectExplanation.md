### GreenThicks — E-commerce Platform

GreenThicks is an e-commerce platform designed to allow users to browse products, manage their cart, place orders and manage their account. The system also has administrative and delivery-related functionality.

I mainly worked on the backend and was responsible for building the server-side functionality and APIs.

### Technology Stack

Frontend:

* Next.js
* React
* JavaScript

Backend:

* Node.js
* Express.js

Database:

* MongoDB
* Mongoose

Other technologies/services:

* JWT
* bcrypt
* Nodemailer
* Passport
* Google OAuth
* Razorpay
* Azure Blob Storage
* Redis
* Twilio

### Architecture

The application follows a typical frontend-backend architecture.

The Next.js frontend communicates with the Node.js/Express backend through REST APIs.

The backend is organized roughly into:

Routes → Controllers → Models/Services → MongoDB

For example, requests related to products go through the product routes and controllers, which interact with the MongoDB models.

I kept different business areas separated into different route modules rather than putting all the APIs into one large file.

### Main modules

The backend contains modules for:

* Authentication
* Products
* Orders
* Cart
* Addresses
* Coupons
* Invoices
* Delivery
* Favorites
* Users
* Administration
* Notifications
* Cancellations
* Returns
* Banners
* Delivery management

### Authentication

One important part I worked with was authentication.

During signup, the backend validates the user's input, checks whether the email and username already exist, hashes the password using bcrypt and stores the user.

The system also creates an email verification token. The token is stored with an expiry time and is sent to the user through an email service.

During login, the user can provide either an email or username. The backend verifies the credentials and generates a JWT token after successful authentication.

The JWT contains information such as the user's ID and whether the user has administrator privileges.

This token can then be used to authenticate subsequent requests.

### Why hash passwords?

I would never store a user's password directly in the database.

Instead, I use bcrypt to create a one-way hash.

When the user logs in, bcrypt compares the supplied password with the stored hash.

This means the original password does not need to be stored.

### Authorization

Authentication answers:

"Who is this user?"

Authorization answers:

"What is this user allowed to do?"

For example, administrative operations check whether the authenticated user has admin privileges before allowing operations such as retrieving all users or deleting users.

### REST APIs

The backend exposes different REST endpoints based on functionality.

For example:

/api/auth
/api/products
/api/orders
/api/cart
/api/addresses
/api/coupons
/api/invoices

The server also has a health endpoint which can be used to verify that the backend is running.

### Error handling

I also implemented centralized error handling for common cases such as validation errors, invalid IDs and duplicate database values.

Instead of allowing the server to crash, the backend returns an appropriate HTTP response and error message.

### CORS

Since the frontend and backend can run on different origins, I configured CORS to allow the required frontend origins and HTTP methods.

This allows the browser-based frontend to communicate with the backend securely.

### My contribution

My major contribution was on the backend side.

I worked on the API layer, application logic, database interaction and integration required for the e-commerce functionality.

I also worked on integrating the backend with the frontend and deployment environment.

### How I would explain the complete flow

Suppose a user places an order.

The flow is approximately:

User → Next.js frontend → REST API → Express route → controller/service → MongoDB → response → frontend.

The frontend sends the required order information.

The backend authenticates the request, validates the data, performs the required business logic and stores the order.

The API then sends a response back to the frontend, which updates the user interface.

### Main challenge

One challenge in an e-commerce application is that there are many interconnected modules.

For example, an order can involve the user, cart, products, address, payment and delivery.

I therefore separated the application into different modules and routes so that each part had a clear responsibility.

### What I learned

This project helped me understand how a real-world backend is structured rather than just creating individual APIs.

I learned about authentication, authorization, database relationships, API design, validation, error handling, external services and frontend-backend integration.

### Future improvements

If I continue developing the project, I would focus on stronger automated testing, improved transaction handling for order/payment operations, better observability and more systematic API documentation.

----

### Educational Task Management System

This project is a collaborative task management platform designed for educational environments where tutors can assign tasks to students and monitor their progress.

The main idea was to solve the problem of managing assignments, deadlines and student progress in one centralized system.

### Users

There are mainly two types of users:

1. Tutor
2. Student

A tutor can create and assign tasks, monitor progress and view statistics.

A student can view assigned tasks, update progress and track deadlines.

### Technology Stack

Frontend:

* Next.js
* React
* JavaScript

Backend:

* Java
* Spring Boot

Database:

* MySQL
* Spring Data JPA

### Architecture

The project follows a frontend-backend architecture.

Next.js handles the user interface.

The frontend communicates with the Spring Boot backend through REST APIs.

The Spring Boot backend handles:

Controller → Service → Repository → Database

The controller receives HTTP requests.

The service layer contains business logic.

The repository layer communicates with the database through JPA.

### Task management

The central entity in the application is the Task.

A task can contain information such as:

* Title
* Description
* Subject
* Deadline
* Assigned student
* Tutor
* Status
* Progress

The backend provides APIs for CRUD operations.

For example:

GET /api/tasks

can retrieve tasks.

POST /api/tasks

creates a task.

PUT /api/tasks/{taskId}

updates a task.

DELETE /api/tasks/{taskId}

deletes a task.

There are also APIs to retrieve tasks belonging to a particular tutor or student.

### File upload

One interesting implementation is task creation with multipart/form-data.

The request can contain both:

1. Task information as JSON
2. An optional file attachment

The controller receives the JSON as a request part and converts it into a TaskRequest object using Jackson's ObjectMapper.

The optional MultipartFile is then passed to the service layer.

This allows tasks to contain supporting documents.

### Upcoming and overdue tasks

The backend also provides APIs for scheduling-related functionality.

For example, upcoming tasks can be retrieved between a start and end date.

There is also an endpoint for retrieving overdue tasks.

This allows the frontend to build calendar and deadline views.

### Tutor functionality

A tutor can:

* Create tasks
* Assign tasks
* Update tasks
* Delete tasks
* View tasks
* Monitor student progress
* View statistics
* Manage settings

### Student functionality

A student can:

* View assigned tasks
* Track task status
* Update progress
* View deadlines
* Use the calendar
* Manage account settings

### Statistics

The system provides statistics related to task completion and student performance.

For example, tutors can analyze completion rates, subject performance, grade distribution and submission timelines.

This makes the system more than just a CRUD application because the data is also used for analysis.

### Why Spring Boot?

I used Spring Boot because it provides a structured way to build Java REST APIs.

It also integrates well with JPA and database systems.

Spring's dependency injection makes it easier to separate controllers, services and repositories.

### Why JPA?

JPA allows Java objects to be mapped to database tables.

Instead of writing SQL for every basic database operation, repositories can provide operations such as saving, finding and deleting entities.

### My contribution

I worked on the application development, particularly the Next.js frontend and Spring Boot backend integration.

The project helped me understand how a Java-based backend communicates with a modern React/Next.js frontend.

### Main challenge

One challenge was maintaining consistency between frontend state and backend data.

For example, when a tutor updates a task, the frontend needs to reflect the new task state correctly.

Another challenge was handling different workflows for tutors and students.

### What I learned

This project gave me practical experience with:

* Spring Boot
* REST APIs
* JPA
* MySQL
* Next.js
* CRUD operations
* File uploads
* Role-based application logic
* Calendar-based data
* Statistics and analytics
* Frontend-backend integration

### Future improvements

I would improve the project by implementing stronger authentication and authorization, automated tests, better validation, notifications and production-level deployment and monitoring.

----

### System Assistant Application

System Assistant is a voice-controlled desktop application that allows a user to interact with the computer using spoken commands.

The goal was to combine speech recognition, AI and desktop application technologies into one practical application.

### Technology Stack

Desktop:

* Electron.js

Frontend:

* HTML
* CSS
* JavaScript

Backend/logic:

* Python

AI/services:

* Azure OpenAI
* Azure Cognitive Services Speech

Other libraries:

* SpeechRecognition
* PyWhatKit
* Requests

### Architecture

The application has two major parts.

The Electron side provides the desktop application and user interface.

The Python side handles the assistant's voice-processing and task-execution logic.

The Electron main process launches the Python assistant as a child process.

The Python process produces responses, and Electron forwards the output to the renderer.

### Voice input

The user speaks a command.

The Python application uses the SpeechRecognition library to capture audio from the microphone.

The recognized text is converted into a command string.

The assistant checks for the activation keyword "captain".

For example:

"captain open youtube"

The application extracts the command after the activation keyword.

### AI processing

The project uses Azure OpenAI to process conversational input.

A conversation list is maintained containing system and user messages.

The user's command is sent to the Azure OpenAI chat completion API.

The returned response is then used by the assistant.

### Command execution

Some commands are mapped to actual system actions.

For example:

"open youtube"

opens YouTube using the webbrowser module.

"open google"

opens Google.

"play [song]"

uses PyWhatKit to play the requested song on YouTube.

"today's news"

calls the news API and returns headlines.

"today's time"

returns the current time.

### Text-to-speech

After generating a response, the assistant uses Azure Cognitive Services Speech to convert text into speech.

I configured an Azure neural voice so the assistant can speak naturally.

So the overall pipeline is:

Voice → Speech Recognition → Text → AI/Command Logic → Action → Text Response → Azure Speech → Voice

### Electron integration

Electron is used to turn the assistant into a desktop application.

The Electron main process creates the application window.

It uses Node's child_process module to start the Python assistant.

The Python process's stdout is captured by Electron.

Electron then sends the assistant's output to the renderer process.

### Security consideration

The Electron application uses:

nodeIntegration: false

and

contextIsolation: true

This reduces the ability of renderer-side code to directly access Node.js APIs.

A preload script is used as the controlled bridge between the renderer and Electron.

### Error handling

The Python assistant handles speech recognition errors, request errors and unexpected exceptions.

For example, if speech cannot be understood, the assistant asks the user to repeat the command.

If the speech service cannot be reached, it reports a connection error.

### My contribution

I worked on integrating the Python assistant logic with the Electron desktop application and Azure services.

The project helped me understand how different technologies can communicate across process boundaries.

### Main challenge

One of the interesting challenges was integrating Python with Electron because Electron runs on Node.js while the assistant logic was written in Python.

I solved this by using Electron's child_process functionality to start the Python process and communicate through standard output.

### What I learned

I learned about:

* Speech recognition
* Text-to-speech
* Azure AI services
* Azure OpenAI
* Electron
* Python
* Node.js child processes
* IPC
* API integration
* Environment variables
* Desktop application architecture

### Future improvements

I would improve the project by introducing a more structured intent system, stronger command validation, asynchronous task handling, better conversation memory and a more secure secrets/configuration system.


---

### Handwritten Digit Recognition Web Application

This project is a machine-learning web application that recognizes handwritten digits from an uploaded image.

The project uses the MNIST dataset for training and a Convolutional Neural Network for classification.

### Technology Stack

Machine Learning:

* Python
* TensorFlow
* Keras
* CNN
* MNIST

Backend:

* Flask

Image processing:

* OpenCV
* PIL

Frontend:

* HTML
* CSS
* JavaScript

### Problem

The goal was to create a system that can take an image containing a handwritten digit and predict which digit from 0 to 9 it represents.

### Dataset

I used the MNIST handwritten digit dataset.

The images are grayscale images of size 28 × 28 pixels.

There are 10 classes:

0, 1, 2, 3, 4, 5, 6, 7, 8, 9.

### Preprocessing

Before training, the images are reshaped into:

28 × 28 × 1

The pixel values are normalized by dividing them by 255.

This converts the pixel values from the range 0–255 into approximately 0–1.

The labels are converted using one-hot encoding because this is a multi-class classification problem.

### CNN architecture

The model uses a Convolutional Neural Network.

The architecture contains:

Conv2D → MaxPooling → Conv2D → MaxPooling → Conv2D → Flatten → Dense → Output

The convolutional layers learn visual features from the handwritten digit.

The pooling layers reduce the spatial dimensions and help retain important features.

Flatten converts the feature maps into a one-dimensional representation.

The dense layer learns the final classification patterns.

The final layer contains 10 neurons because there are 10 digit classes.

It uses softmax so that the model produces probabilities for each digit.

### Training

The model is compiled using:

* Adam optimizer
* Categorical cross-entropy loss
* Accuracy as the evaluation metric

The model is trained for multiple epochs using batches of images.

After training, the model is saved as a Keras model.

### Prediction pipeline

When a user uploads an image:

1. Flask receives the image.
2. The image is converted to grayscale.
3. It is converted into an array.
4. OpenCV resizes it to 28 × 28.
5. Pixel values are normalized.
6. The image is reshaped to match the CNN input.
7. The trained model predicts probabilities.
8. Argmax selects the class with the highest probability.
9. Flask returns the predicted digit as JSON.

The flow is:

Image → Flask → Preprocessing → CNN → Prediction → JSON Response

### Why CNN?

A CNN is suitable for image classification because it can automatically learn spatial patterns such as edges, curves and shapes.

For handwritten digits, these visual features are very important.

### Why softmax?

There are ten possible classes.

Softmax converts the output values into a probability distribution across those ten classes.

The class with the highest probability becomes the prediction.

### Why categorical cross-entropy?

This is a multi-class classification problem where the labels are represented using one-hot encoding.

Categorical cross-entropy is therefore suitable for measuring the difference between the predicted probability distribution and the actual class.

### My contribution

I worked on the complete pipeline from model training to web deployment.

I trained the CNN, saved the model and integrated it into a Flask application that accepts uploaded images and returns predictions.

### Main challenge

One important part was making sure that the input image used during prediction had the same preprocessing format as the training data.

The model expects a 28 × 28 grayscale normalized image.

Therefore, uploaded images need to be converted, resized, normalized and reshaped before prediction.

### What I learned

This project helped me understand the complete machine-learning workflow:

Dataset → Preprocessing → Model → Training → Evaluation → Saving → Deployment → Prediction API

It also helped me understand how a machine-learning model can be integrated into a web application.

### Future improvements

I would add better preprocessing for real-world handwriting, confidence scores, image cropping and centering, data augmentation and a drawing canvas so users can directly draw a digit instead of uploading an image.


----

### Anime Aura New Tab — Chrome Extension

Anime Aura New Tab is a Chrome extension that replaces the default browser new-tab page with a customizable anime-inspired dashboard.

I created and published it on the Chrome Web Store.

### Technology Stack

* JavaScript
* HTML
* CSS
* Chrome Extension APIs
* Manifest V3
* LocalStorage
* Canvas API

There are no external JavaScript dependencies in the extension.

### How the extension works

The extension uses Chrome's new-tab override functionality.

In the Manifest V3 configuration, the extension specifies:

chrome_url_overrides

with:

newtab: newtab.html

This tells Chrome to load my custom HTML page whenever the user opens a new tab.

### Wallpaper system

The extension contains default background images.

When the page loads, JavaScript selects an image and sets it as the page background.

The background automatically changes every 30 seconds.

I also implemented logic to avoid immediately showing the same image again.

### Custom wallpapers

Users can upload their own images.

Instead of sending these images to a server, I store them locally in the browser.

Before storing large images, the extension can resize and compress them.

This reduces the amount of local storage used.

### Why localStorage?

The extension doesn't need a backend because the data is specific to the user's browser.

Things such as:

* Shortcuts
* Custom images
* Settings

can be stored locally.

This also means the user doesn't need to create an account.

### Handling storage limitations

Browser localStorage has limited storage capacity.

Large uploaded images can cause a QuotaExceededError.

I therefore added a safe storage function that catches storage errors and informs the user.

I also implemented image compression before storing custom images.

### Shortcut launcher

The extension provides a circular shortcut launcher.

It comes with default shortcuts such as:

* YouTube
* Gmail
* GitHub
* Reddit
* ChatGPT
* Grok

Users can add their own shortcuts.

Each shortcut stores information such as its name, URL and icon.

### Automatic icons

The extension tries to determine the domain from the URL.

For known websites, it uses predefined favicon URLs.

For other websites, it can use Google's favicon service.

If an icon cannot be determined, it generates a fallback icon containing the first letter of the shortcut name.

### Inactivity mode

One of the features I implemented is an inactivity-triggered screensaver.

If the user doesn't interact with the page for around 35 seconds:

* The shortcuts disappear.
* The plus button is hidden.
* Fireworks animation starts.

When the user interacts with the page again, the fireworks stop and the shortcuts reappear.

### Fireworks implementation

The fireworks are rendered using the HTML Canvas API.

I created a Firework class that manages:

* Position
* Velocity
* Particles
* Explosion
* Particle lifetime
* Trails
* Animation

Different explosion patterns are generated using different particle arrangements.

### Page Visibility API

I also considered whether the browser tab is currently visible.

If the tab is hidden, the extension stops the animation.

When the tab becomes visible again, it can restart the required animation.

This avoids unnecessary animation work when the user isn't looking at the page.

### Performance considerations

Continuous animations can consume CPU resources.

Therefore, I stop the fireworks when the user becomes active again.

I also debounce resize handling so that expensive repositioning operations don't execute repeatedly while the browser window is being resized.

### My contribution

I designed and implemented the extension functionality, including:

* New-tab replacement
* Wallpaper rotation
* Custom image support
* Shortcut management
* Favicon handling
* Local storage
* Inactivity detection
* Canvas fireworks
* Responsive behavior

I also packaged and published the extension.

### What I learned

This project taught me about browser extension architecture, Manifest V3, browser storage, DOM events, the Page Visibility API, Canvas animations and client-side performance optimization.

It also gave me experience taking a project from development to an actual published browser extension.
