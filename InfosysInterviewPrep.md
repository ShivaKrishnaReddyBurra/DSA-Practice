\### What is OOP?

\*\*Object-Oriented Programming (OOP)\*\* is a programming paradigm based on the concept of \*\*"objects,"\*\* which can contain data (in the form of fields or attributes) and code (in the form of procedures or methods). It focuses on organizing software design around data and objects rather than logic and functions.



\---



\### What are the four pillars of OOP?

The four pillars of OOP are:

\* \*\*Encapsulation:\*\* Hiding internal state and requiring all interaction to be performed through well-defined methods.

\* \*\*Inheritance:\*\* Deriving new classes from existing ones to reuse code.

\* \*\*Polymorphism:\*\* Allowing a single interface to represent different underlying forms (actions).

\* \*\*Abstraction:\*\* Hiding complex implementation details and showing only the essential features.



\---



\### What is a class?

A \*\*class\*\* is a blue-print, template, or prototype from which individual objects are created. It defines the properties (variables) and behaviors (methods) that its objects will have, but it does not occupy any physical memory space itself.



\---



\### What is an object?

An \*\*object\*\* is an instance of a class. It is a physical entity that has state (data stored in fields) and behavior (actions performed by methods) and occupies memory space during program execution.



\---



\### What is inheritance?

\*\*Inheritance\*\* is a mechanism where one class (subclass/child) acquires the properties and behaviors of another class (superclass/parent). It facilitates \*\*code reusability\*\* and establishes an "IS-A" relationship between classes.



\---



\### What is polymorphism?

\*\*Polymorphism\*\* (meaning "many forms") is the ability of an object, variable, or method to take on multiple forms. It allows you to perform a single action in different ways depending on the object it is acting upon.



\---



\### Overloading vs Overriding?

Both are mechanisms used to achieve polymorphism, but they work differently:



| Feature | Method Overloading (Compile-time) | Method Overriding (Runtime) |

| :--- | :--- | :--- |

| \*\*Location\*\* | Happens within the \*\*same class\*\*. | Happens between a \*\*parent and a child class\*\*. |

| \*\*Parameters\*\* | Must have \*\*different\*\* parameter lists. | Must have the \*\*exact same\*\* parameter list. |

| \*\*Return Type\*\* | Can be different. | Must be the same or a covariant type. |



\---



\### Abstraction vs Encapsulation?

While both hide information, they address different design concerns:



| Feature | Abstraction | Encapsulation |

| :--- | :--- | :--- |

| \*\*Focus\*\* | \*\*What\*\* an object does, rather than \*how\* it does it. | \*\*Hiding data\*\* and wrapping code and data together. |

| \*\*Implementation\*\* | Achieved using \*\*abstract classes\*\* and \*\*interfaces\*\*. | Achieved using \*\*private access modifiers\*\* and getters/setters. |

| \*\*Goal\*\* | Reduces design and conceptual complexity. | Protects an object's internal state from unauthorized access. |



\---



\### What is a constructor?

A \*\*constructor\*\* is a special block of code inside a class that is automatically called when a new instance (object) of that class is created. It has the exact same name as the class and has no return type. Its primary job is to \*\*initialize the object's variables\*\*.



\---



\### Why is Java platform-independent?

Java is platform-independent because its compiler transforms source code into an intermediate format called \*\*bytecode (`.class` files)\*\* instead of machine code. This bytecode is platform-neutral and can run on any computer that has a \*\*Java Virtual Machine (JVM)\*\* installed, matching Java's core philosophy of \*\*"Write Once, Run Anywhere."\*\*



