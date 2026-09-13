## What is OOP?

**Object-Oriented Programming (OOP)** is a programming paradigm based on the concept of **objects**, which contain data (attributes or fields) and code (methods). It focuses on organizing software around **objects and data** rather than functions and logic.

---

## What are the four pillars of OOP?

The four pillars of OOP are:

1. **Encapsulation:** Hiding an object's internal state and allowing interaction through well-defined methods.
2. **Inheritance:** Deriving new classes from existing classes to reuse code and establish an **IS-A** relationship.
3. **Polymorphism:** Allowing the same interface or method to behave differently depending on the object or context.
4. **Abstraction:** Hiding complex implementation details and exposing only the essential features.

---

## What is a Class?

A **class** is a blueprint, template, or prototype from which objects are created.

It defines the **properties (variables)** and **behaviors (methods)** that its objects will have.

> **Example:** A `Car` class can define properties such as `color` and `speed`, and methods such as `start()` and `stop()`.

---

## What is an Object?

An **object** is an **instance of a class**.

It has:

* **State:** Data stored in its fields or variables.
* **Behavior:** Actions performed through its methods.
* **Identity:** A unique existence in memory.

> **Example:** If `Car` is a class, then `myCar` can be an object of the `Car` class.

---

## What is Inheritance?

**Inheritance** is a mechanism where one class (**child/subclass**) acquires the properties and behaviors of another class (**parent/superclass**).

It promotes:

* **Code reusability**
* **Extensibility**
* **IS-A relationships**

> **Example:** `Dog` can inherit from `Animal`, because a dog **IS-A** animal.

---

## What is Polymorphism?

**Polymorphism** means **"many forms."**

It allows the same interface, method, or reference to represent different forms or behaviors.

For example, a method called `sound()` can behave differently depending on the object:

```java
Animal a = new Dog();
a.sound(); // Dog's implementation
```

The same `sound()` method can produce different behavior for a `Dog`, `Cat`, or other animal.

---

## Overloading vs Overriding

Both are commonly associated with polymorphism, but they work differently.

| Feature                   | Method Overloading                                  | Method Overriding                              |
| ------------------------- | --------------------------------------------------- | ---------------------------------------------- |
| **Polymorphism**          | Compile-time                                        | Runtime                                        |
| **Location**              | Usually within the same class                       | Parent-child classes                           |
| **Parameters**            | Must have different parameter lists                 | Must have the same parameter list              |
| **Return Type**           | Can be different, but cannot be the only difference | Same or covariant return type                  |
| **Inheritance Required?** | No                                                  | Yes                                            |
| **Purpose**               | Same method name with different inputs              | Child class provides a specific implementation |

### Example of Overloading

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

### Example of Overriding

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

---

## Abstraction vs Encapsulation

Both concepts involve hiding information, but they solve different problems.

| Feature            | Abstraction                                   | Encapsulation                                           |
| ------------------ | --------------------------------------------- | ------------------------------------------------------- |
| **Focus**          | **What** an object does                       | **How data is protected and organized**                 |
| **Purpose**        | Hides implementation complexity               | Protects internal state                                 |
| **Achieved Using** | Abstract classes and interfaces               | Access modifiers, getters, and setters                  |
| **Main Goal**      | Reduce conceptual complexity                  | Control access to data                                  |
| **Example**        | `Car.start()` without exposing engine details | Making `speed` private and accessing it through methods |

### Simple Difference

> **Abstraction:** Focuses on **what to show** and **what to hide**.

> **Encapsulation:** Focuses on **bundling data and methods together** and **controlling access to the data**.

---

## What is a Constructor?

A **constructor** is a special member of a class that is automatically called when an object is created.

In Java:

* It has the **same name as the class**.
* It has **no return type**, not even `void`.
* It is mainly used to **initialize objects**.
* It is automatically invoked when using the `new` keyword.

### Example

```java
class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

Student s = new Student("Shiva");
```

Here, `Student(String name)` is the constructor.

---

## Why is Java Platform-Independent?

Java is platform-independent because Java source code is compiled into **bytecode** rather than directly into machine-specific code.

The process is:

```text
Java Source Code
       ↓
    Compiler
       ↓
   Bytecode (.class)
       ↓
      JVM
       ↓
Operating System
```

The **Java Virtual Machine (JVM)** executes the bytecode on the target operating system.

Therefore, the same `.class` file can run on different platforms as long as a compatible JVM is available.

This is the idea behind:

> **"Write Once, Run Anywhere."**
