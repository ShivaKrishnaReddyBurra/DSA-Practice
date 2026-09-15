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


# JVM, JRE and JDK

## JVM (Java Virtual Machine)

* **Definition:** JVM is an engine that loads and executes Java bytecode.
* **Function:** It executes Java bytecode and converts it into machine-specific instructions that the underlying operating system and hardware can execute.
* **Key Features:**

  * Provides **platform independence** by allowing the same bytecode to run on different operating systems.
  * Handles **memory management**.
  * Performs **garbage collection**.
  * Provides a runtime environment for executing Java programs.

> **In simple terms:** JVM is responsible for **running Java programs**.

---

## JRE (Java Runtime Environment)

* **Definition:** JRE is a software environment that provides everything required to **run Java applications**.
* **Composition:**

  ```text
  JRE = JVM + Java Class Libraries + Supporting Files
  ```
* **Use Case:** Primarily intended for running Java applications rather than developing them.
* **Important:** JRE does not provide development tools such as the Java compiler (`javac`).

> **In simple terms:** JRE provides the **environment required to run Java programs**.

---

## JDK (Java Development Kit)

* **Definition:** JDK is a complete software development kit used to **develop, compile, debug, and run Java applications**.
* **Composition:**

  ```text
  JDK = JRE + Development Tools
  ```
* **Development Tools include:**

  * Java compiler (`javac`)
  * Java debugger
  * JAR packaging tools
  * Documentation tools
  * Other Java development utilities
* **Use Case:** Required by developers to **write, compile, test, debug, and package** Java applications.

> **In simple terms:** JDK provides everything needed to **develop Java programs**.

---

## Relationship Between JVM, JRE and JDK

```text
JDK
│
├── Development Tools
│   ├── javac (Compiler)
│   ├── Debugger
│   ├── JAR Tool
│   └── Other Tools
│
└── JRE
    │
    ├── JVM
    │   └── Executes Java Bytecode
    │
    └── Java Class Libraries
```

### Quick Comparison

| Feature                        | JVM           | JRE                          | JDK                        |
| ------------------------------ | ------------- | ---------------------------- | -------------------------- |
| **Purpose**                    | Runs bytecode | Provides runtime environment | Develops Java applications |
| **Contains JVM**               | —             | Yes                          | Yes                        |
| **Contains Java Libraries**    | No            | Yes                          | Yes                        |
| **Contains Compiler**          | No            | No                           | Yes                        |
| **Contains Development Tools** | No            | No                           | Yes                        |
| **Used By**                    | Runtime       | End users / runtime          | Developers                 |

### Easy Way to Remember

> **JVM → Runs Java bytecode**
> **JRE → Runs Java applications**
> **JDK → Develops Java applications**

**JDK > JRE > JVM**


# Operating Systems (OS) – Interview Notes

## What is an Operating System?

An **Operating System (OS)** is a software layer that **manages computer hardware and provides common services to application programs**.

Examples of operating systems include **Windows, Linux, macOS, Android, and iOS**.

---

## Main Functions of an Operating System

### 1. Process Management

The OS manages the execution of processes and threads.

It is responsible for:

* Creating and terminating processes.
* Scheduling processes for CPU execution.
* Managing threads.
* Handling process synchronization and communication.

---

### 2. Memory Management

The OS manages the computer's **primary memory (RAM)**.

It is responsible for:

* Allocating and deallocating memory.
* Tracking which memory locations are being used.
* Managing virtual memory.
* Providing memory protection between processes.

---

### 3. File System Management

The OS manages how data is stored and organized on storage devices.

It handles:

* Creating and deleting files and directories.
* Reading and writing files.
* File permissions.
* Organizing data on storage devices.

---

### 4. Device Management

The OS manages communication between software and hardware devices.

It uses **device drivers** to communicate with hardware such as:

* Keyboard
* Mouse
* Printer
* Disk drives
* Network adapters

---

### 5. Security and Protection

The OS protects system resources and controls access to them.

It provides:

* User authentication.
* Access control and permissions.
* Process isolation.
* Protection of system resources and memory.

---

# Program vs Process vs Thread

| Feature        | Program                              | Process                           | Thread                                          |
| -------------- | ------------------------------------ | --------------------------------- | ----------------------------------------------- |
| **Definition** | A set of instructions stored on disk | A running instance of a program   | Smallest unit of execution within a process     |
| **State**      | Passive                              | Active                            | Active                                          |
| **Memory**     | Does not require execution memory    | Has its own process address space | Shares memory with other threads of the process |
| **Execution**  | Not executing                        | Executing                         | Executes part of a process                      |
| **Example**    | `chrome.exe` stored on disk          | Running Chrome application        | A Chrome thread handling a particular task      |

### Simple Example

```text
Program
   ↓
Running the program
   ↓
Process
   ↓
Multiple execution units
   ↓
Threads
```

> **Program = What is stored**
> **Process = Program in execution**
> **Thread = Unit of execution inside a process**

---

# Multithreading

**Multithreading** is the ability of a process to execute multiple threads concurrently.

Multiple threads within the same process generally **share the process's memory and resources**, while each thread has its own execution state, such as its stack and registers.

### Advantages

* Better CPU utilization.
* Improved application responsiveness.
* Allows multiple tasks to execute concurrently.
* Can improve performance for suitable workloads.

### Example

A web browser may use different threads for:

```text
Browser Process
│
├── UI Thread
├── Network Thread
├── Rendering Thread
└── Background Task Thread
```

---

# Context Switching

**Context switching** is the process of saving the current execution state of a running process or thread and loading the saved state of another process or thread.

The context can include information such as:

* CPU registers.
* Program counter.
* Stack pointer.
* Other CPU execution state.

### Example

```text
Process A is running
       ↓
Save Process A's context
       ↓
Load Process B's context
       ↓
Process B starts/resumes execution
```

Context switching allows the CPU to switch between multiple processes or threads, but it also introduces **overhead**.

---

# User Mode vs Kernel Mode

Modern operating systems typically provide different privilege levels to protect the system.

## User Mode

**User mode** is a restricted execution mode in which normal application programs run.

Applications generally cannot directly:

* Access hardware.
* Access protected kernel memory.
* Execute privileged CPU instructions.

---

## Kernel Mode

**Kernel mode** is a privileged execution mode used by the operating system kernel.

The kernel can:

* Access hardware.
* Access protected memory.
* Execute privileged instructions.
* Manage system resources.

---

## System Calls

A **system call** is a mechanism through which a user-space application requests a service from the operating system kernel.

Examples include requests to:

* Open or read a file.
* Create a process.
* Allocate certain resources.
* Communicate over a network.

### Simple Flow

```text
User Application
       ↓
  System Call
       ↓
      Kernel
       ↓
Hardware / OS Resource
```

> **User Mode → Restricted**
> **Kernel Mode → Privileged**

---

# CPU Scheduling

**CPU scheduling** is the process of selecting which ready process or thread should get the CPU next.

### Why Do We Need CPU Scheduling?

CPU scheduling aims to:

* Maximize **CPU utilization**.
* Increase **throughput**.
* Minimize **waiting time**.
* Minimize **turnaround time**.
* Improve **response time**.
* Provide fairness among processes.

---

# Preemptive vs Non-Preemptive Scheduling

| Feature                    | Preemptive                             | Non-Preemptive                             |
| -------------------------- | -------------------------------------- | ------------------------------------------ |
| **CPU can be taken away?** | Yes                                    | No                                         |
| **Process interruption**   | Can be interrupted by the OS           | Generally runs until it finishes or blocks |
| **Response time**          | Usually better for interactive systems | Can be worse for interactive systems       |
| **Context switching**      | More frequent                          | Generally less frequent                    |
| **Example**                | Round Robin                            | FCFS                                       |

### Preemptive Scheduling

In **preemptive scheduling**, the OS can interrupt a running process and assign the CPU to another process.

### Non-Preemptive Scheduling

In **non-preemptive scheduling**, a process keeps the CPU until it finishes its CPU burst or voluntarily enters a waiting/blocked state.

---

# CPU Scheduling Algorithms

## 1. FCFS – First-Come, First-Served

**FCFS** executes processes in the order in which they arrive in the ready queue.

* **Type:** Non-preemptive.
* **Scheduling principle:** First process to arrive gets the CPU first.
* **Advantage:** Simple and easy to implement.
* **Disadvantage:** Can cause the **convoy effect**, where short processes wait behind a long process.

### Example

```text
Arrival Order:

P1 → P2 → P3

Execution:

P1 → P2 → P3
```

---

## 2. SJF – Shortest Job First

**SJF** selects the process with the **smallest expected CPU burst**.

* Can be **preemptive or non-preemptive**.
* Non-preemptive SJF selects the shortest available job.
* Its preemptive version is called **Shortest Remaining Time First (SRTF)**.

### Advantage

It can provide a low **average waiting time** when burst lengths can be estimated accurately.

### Disadvantage

Long processes may experience **starvation** if short processes continually arrive.

---

## 3. Round Robin (RR)

**Round Robin** is a **preemptive** scheduling algorithm commonly used for time-sharing systems.

Each process receives a fixed amount of CPU time called a **time quantum**.

After the quantum expires, the process is moved to the back of the ready queue if it still has work to do.

### Example

```text
Ready Queue:

P1 → P2 → P3

Time Quantum = 2 ms

Execution:

P1 → P2 → P3 → P1 → P2 → ...
```

### Advantage

* Fair CPU allocation.
* Good response time for interactive applications.

### Disadvantage

If the time quantum is too small, excessive context switching can reduce efficiency.

---

## 4. Priority Scheduling

In **Priority Scheduling**, processes are selected based on their assigned priority.

* Can be **preemptive or non-preemptive**.
* A higher-priority process is generally selected before a lower-priority process.

### Example

```text
P1 → Priority 3
P2 → Priority 1
P3 → Priority 2

If 1 = Highest Priority:

Execution:

P2 → P3 → P1
```

### Disadvantage

Low-priority processes may suffer from **starvation**.

### Solution: Aging

**Aging** gradually increases the priority of processes that have been waiting for a long time, helping prevent starvation.

---

Absolutely. I cleaned up the formatting, fixed the broken Stack vs Heap table, and made a few technical statements more accurate for **OS interview preparation**.

# Operating Systems – Deadlock and Memory Management

# Deadlock

A **deadlock** is a situation in a multitasking system where a set of processes are permanently blocked because each process is holding one or more resources and waiting for resources held by another process in the same cycle.

### Simple Example

```text
P1 holds Resource A → waits for Resource B
P2 holds Resource B → waits for Resource A

        ┌──────────────┐
        ↓              │
       P1              │
        │              │
        ↓              │
   Resource B          │
        │              │
        ↓              │
       P2 ─────────────┘
   holds Resource B
   waits for Resource A
```

Neither process can proceed, resulting in a **deadlock**.

---

# Four Necessary Conditions for Deadlock

For a deadlock to occur, **all four conditions must exist simultaneously**.

## 1. Mutual Exclusion

At least one resource must be **non-shareable**, meaning only one process can use it at a time.

> Example: A printer may be assigned to only one process at a time.

---

## 2. Hold and Wait

A process must be **holding at least one resource** while waiting to acquire additional resources held by other processes.

> Example: P1 holds Resource A and waits for Resource B.

---

## 3. No Preemption

A resource cannot be forcibly taken away from the process holding it.

The process must voluntarily release the resource after it has finished using it.

---

## 4. Circular Wait

A circular chain of processes must exist where each process is waiting for a resource held by the next process in the chain.

```text
P1 → waits for resource held by P2
P2 → waits for resource held by P3
P3 → waits for resource held by P1
```

This creates a cycle.

---

# Deadlock Prevention vs Deadlock Avoidance

| Feature       | Deadlock Prevention                     | Deadlock Avoidance                                               |
| ------------- | --------------------------------------- | ---------------------------------------------------------------- |
| **Approach**  | Prevents deadlock by design             | Dynamically evaluates resource allocation                        |
| **Method**    | Breaks at least one necessary condition | Ensures the system remains in a safe state                       |
| **Decision**  | Uses predefined rules                   | Makes decisions based on current resource state and future needs |
| **Example**   | Preventing hold-and-wait                | Banker's Algorithm                                               |
| **Main Goal** | Make deadlock impossible                | Avoid entering an unsafe state                                   |

## Deadlock Prevention

**Deadlock prevention** ensures that at least one of the four necessary conditions can never occur.

For example:

* Prevent **hold and wait** by requiring a process to request all required resources at once.
* Prevent **circular wait** by imposing an ordering on resource types.
* Allow **resource preemption** where possible.

> **Key idea:** Prevention breaks one of the conditions required for deadlock.

---

## Deadlock Avoidance

**Deadlock avoidance** dynamically examines resource requests and determines whether granting a request could lead to an unsafe state.

The OS grants a request only if the system can remain in a **safe state**.

> **Key idea:** Avoidance does not necessarily prevent the conditions from occurring; instead, it carefully controls resource allocation to avoid deadlock.

---

# Banker's Algorithm

The **Banker's Algorithm** is a classic **deadlock avoidance algorithm** used when a system has multiple instances of resources.

It is based on the analogy of a banker who provides loans to customers while ensuring that the bank will always have enough resources to satisfy all customers eventually.

### Basic Idea

When a process requests resources:

1. The OS checks whether the requested resources are available.
2. It **temporarily simulates** granting the request.
3. It checks whether the resulting state is **safe**.
4. If the state is safe, the request is granted.
5. If the state is unsafe, the request is delayed.

### Important Terms

* **Available:** Resources currently available.
* **Maximum:** Maximum resources a process may need.
* **Allocation:** Resources currently allocated to a process.
* **Need:** Remaining resources required by a process.

```text
Need = Maximum - Allocation
```

> **Safe State:** A state in which there exists at least one sequence in which all processes can complete without causing deadlock.

---

# Memory Management

Memory management is one of the major responsibilities of an operating system.

The OS manages:

* Allocation and deallocation of memory.
* Address translation.
* Memory protection.
* Virtual memory.
* Efficient utilization of RAM.

---

# Paging vs Segmentation

| Feature             | Paging                           | Segmentation                                          |
| ------------------- | -------------------------------- | ----------------------------------------------------- |
| **Division**        | Fixed-size pages                 | Variable-size segments                                |
| **Physical Memory** | Divided into frames              | Not necessarily divided according to logical segments |
| **Logical Memory**  | Divided into pages               | Divided into logical segments                         |
| **Size**            | Fixed                            | Variable                                              |
| **Based On**        | Physical memory management       | Programmer's logical view                             |
| **Fragmentation**   | May cause internal fragmentation | May cause external fragmentation                      |
| **Example**         | Page 0, Page 1, Page 2           | Code, Stack, Heap, Data                               |

## Paging

**Paging** is a memory management technique that divides:

* Logical/virtual memory into fixed-size **pages**.
* Physical memory into fixed-size **frames**.

A page can be loaded into any available physical frame, so contiguous physical memory allocation is not required.

```text
Virtual Memory                 Physical Memory

Page 0 ─────────────────────→ Frame 5
Page 1 ─────────────────────→ Frame 2
Page 2 ─────────────────────→ Frame 8
Page 3 ─────────────────────→ Frame 1
```

---

## Segmentation

**Segmentation** divides a program's logical address space into **variable-sized segments** based on meaningful parts of a program.

Examples include:

* Code segment
* Data segment
* Stack segment
* Heap segment

```text
Program
│
├── Code Segment
├── Data Segment
├── Heap Segment
└── Stack Segment
```

> **Easy way to remember:**
> **Paging → Fixed-size blocks**
> **Segmentation → Logical, variable-size blocks**

---

# Virtual Memory

**Virtual memory** is a memory management technique that allows a process to execute even when its entire address space is not currently loaded into physical RAM.

It provides each process with the abstraction of a large, continuous **virtual address space**, while the OS and hardware map virtual addresses to physical memory.

Some pages can remain on secondary storage until they are needed.

### Advantages

* Allows programs larger than available physical RAM to execute.
* Allows more processes to reside in memory.
* Provides process isolation.
* Makes memory management more flexible.

---

# Page Fault

A **page fault** occurs when a process accesses a virtual memory page that is not currently present in physical RAM.

### Page Fault Process

```text
Process accesses a page
          ↓
Is page in RAM?
     ↙           ↘
   Yes            No
    ↓              ↓
Continue       Page Fault
execution          ↓
             OS loads page
              from storage
                   ↓
             Update page table
                   ↓
             Resume execution
```

A page fault is **not necessarily an error**. It is a normal mechanism used by virtual memory systems.

However, frequent page faults can significantly reduce performance.

---

# Thrashing

**Thrashing** occurs when the system spends excessive time handling page faults and moving pages between physical memory and secondary storage instead of executing useful application work.

It usually occurs when processes do not have enough physical memory to keep their active **working sets** in RAM.

### Example

```text
Normal System:

CPU → Executes instructions → Good performance


Thrashing:

CPU → Page Fault
        ↓
     Load Page
        ↓
     Page Fault
        ↓
     Load Page
        ↓
     Page Fault
        ↓
     Load Page
        ↓
     Very little useful execution
```

### Effects of Thrashing

* Very high page-fault rate.
* Heavy disk/secondary-storage activity.
* Low CPU utilization.
* Poor system performance.

> **Easy way to remember:**
> **Page Fault → A required page is not in RAM.**
> **Thrashing → Too many page faults causing severe performance degradation.**

---

# Stack vs Heap Memory

Stack and heap are two important areas of memory used during program execution. Their exact behavior depends on the programming language and runtime, so the following comparison is a **general model**, not a universal rule for every language.

| Feature            | Stack                                                      | Heap                                                                               |
| ------------------ | ---------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| **Allocation**     | Typically automatic                                        | Typically dynamically allocated                                                    |
| **Organization**   | Typically follows LIFO behavior for function call frames   | General-purpose dynamically managed memory                                         |
| **Speed**          | Usually faster                                             | Usually slower than stack allocation                                               |
| **Management**     | Automatically managed as functions execute/return          | Managed by the programmer, runtime, or garbage collector depending on the language |
| **Lifetime**       | Typically tied to function/call-frame lifetime             | Can outlive the function that created it                                           |
| **Size**           | Usually smaller and more limited                           | Usually larger and more flexible                                                   |
| **Common Problem** | Stack overflow                                             | Out-of-memory / allocation failure                                                 |
| **Fragmentation**  | Generally not subject to heap-style external fragmentation | Can suffer from fragmentation depending on the allocator/runtime                   |

---

## Stack Memory

The **stack** is typically used for function-call-related data such as:

* Local variables.
* Function parameters.
* Return addresses.
* Stack frames.
* Saved registers and execution state.

Stack allocation and deallocation are generally very fast because they follow the function-call structure.

### Example

```java
void calculate() {
    int x = 10;
    int y = 20;
}
```

The local variables and function-call information are typically associated with the stack frame for `calculate()`.

---

## Heap Memory

The **heap** is used for dynamically allocated objects and data whose lifetime is not necessarily tied directly to a single function call.

For example, in Java:

```java
class Student {
    String name;
}

Student s = new Student();
```

The `Student` object is typically allocated on the **heap**, while the reference variable `s` is associated with the current stack frame.

The **JVM's garbage collector** is responsible for automatically reclaiming heap objects that are no longer reachable.

---

# Computer Networks – Interview Notes

## What is a Computer Network?

A **computer network** is a collection of interconnected computing devices that communicate with one another to **share data, resources, and services**.

Examples include:

* Home Wi-Fi networks.
* Office networks.
* University networks.
* The Internet.

---

# Network Architecture & Hardware

## LAN vs WAN

| Feature       | LAN                     | WAN                                    |
| ------------- | ----------------------- | -------------------------------------- |
| **Full Form** | Local Area Network      | Wide Area Network                      |
| **Coverage**  | Small geographical area | Large geographical area                |
| **Example**   | Home, office, school    | Internet, connections between cities   |
| **Speed**     | Generally higher        | Generally lower than LAN               |
| **Ownership** | Often privately managed | Often uses multiple providers/networks |

### LAN – Local Area Network

A **LAN** connects devices within a relatively small geographical area such as a:

* Home.
* Office.
* School.
* College.

LANs generally provide high-speed communication between nearby devices.

### WAN – Wide Area Network

A **WAN** connects networks over large geographical areas such as:

* Cities.
* Countries.
* Continents.

The **Internet** is the world's largest interconnected network and can be considered a global WAN.

---

# Network Devices

```text
Hub
  ↓
Broadcasts data to all connected ports

Switch
  ↓
Uses MAC addresses to forward frames within a LAN

Router
  ↓
Uses IP addresses to forward packets between networks
```

## Hub

A **hub** is a basic **Layer 1 (Physical Layer)** networking device.

* Receives incoming data.
* Broadcasts it to **all ports**.
* Does not make forwarding decisions based on MAC addresses.
* Can create unnecessary network traffic.

> **Hub → Broadcasts to everyone**

---

## Switch

A **switch** is typically a **Layer 2 (Data Link Layer)** device.

* Uses **MAC addresses** to make forwarding decisions.
* Learns which MAC addresses are reachable through which ports.
* Forwards Ethernet frames toward the appropriate destination port when known.
* Primarily connects devices within a LAN.

> **Switch → Uses MAC addresses**

---

## Router

A **router** operates primarily at **Layer 3 (Network Layer)**.

* Uses **IP addresses** to forward packets.
* Connects different networks.
* Maintains routing information.
* Determines where packets should be forwarded next.

> **Router → Uses IP addresses**

---

# Network Identifiers

## MAC Address

A **MAC (Media Access Control) address** is a link-layer identifier associated with a network interface.

A traditional Ethernet MAC address is **48 bits (6 bytes)** and is commonly represented in hexadecimal.

Example:

```text
00:1A:2B:3C:4D:5E
```

MAC addresses are primarily used for communication within a **local network/link**.

> **Important:** A MAC address is not necessarily permanently fixed. Modern systems can use **locally administered/randomized MAC addresses**, especially for privacy on Wi-Fi networks.

---

## IP Address

An **IP address** is a logical network-layer address used to identify an interface for communication across IP networks.

There are two major versions:

* **IPv4:** 32-bit address.
* **IPv6:** 128-bit address.

Example IPv4 address:

```text
192.168.1.10
```

An IP address can be assigned:

* Manually.
* Dynamically using **DHCP**.
* By other network configuration mechanisms.

> **MAC → Local/link communication**
> **IP → Communication across networks**

---

## Port Number

A **port number** is a **16-bit number** used by transport-layer protocols such as TCP and UDP to identify a service or endpoint on a host.

Port numbers range from:

```text
0 – 65535
```

Common examples:

|    Port | Protocol | Common Use             |
| ------: | -------- | ---------------------- |
|  **80** | HTTP     | Web traffic            |
| **443** | HTTPS    | Secure web traffic     |
|  **22** | SSH      | Secure remote access   |
|  **53** | DNS      | Domain name resolution |

> **IP address → Identifies the host/interface**
> **Port number → Identifies the application/service endpoint**

---

# OSI Model

The **OSI (Open Systems Interconnection) Model** is a conceptual framework consisting of **7 layers** used to understand how network communication works.

## Seven Layers of the OSI Model

| Layer | Name         | Core Function                                  | Examples              |
| ----: | ------------ | ---------------------------------------------- | --------------------- |
| **7** | Application  | Provides network services to applications      | HTTP, HTTPS, DNS, FTP |
| **6** | Presentation | Data representation, encryption, compression   | TLS, JPEG, ASCII      |
| **5** | Session      | Establishes and manages communication sessions | RPC, NetBIOS          |
| **4** | Transport    | End-to-end delivery, reliability, flow control | TCP, UDP              |
| **3** | Network      | Logical addressing and routing                 | IPv4, IPv6, ICMP      |
| **2** | Data Link    | Framing, MAC addressing, local delivery        | Ethernet, Wi-Fi       |
| **1** | Physical     | Transmission of raw bits over physical media   | Cables, Fiber, Radio  |

### Easy Way to Remember

From Layer 7 to Layer 1:

```text
7 → Application
6 → Presentation
5 → Session
4 → Transport
3 → Network
2 → Data Link
1 → Physical
```

Mnemonic:

> **A**ll **P**eople **S**eem **T**o **N**eed **D**ata **P**rocessing

---

# TCP/IP Model

The **TCP/IP model** is a practical networking model underlying the Internet.

A common four-layer representation is:

| TCP/IP Layer              | OSI Equivalent | Examples        |
| ------------------------- | -------------- | --------------- |
| **Application**           | Layers 5–7     | HTTP, DNS, FTP  |
| **Transport**             | Layer 4        | TCP, UDP        |
| **Internet**              | Layer 3        | IP, ICMP        |
| **Network Access / Link** | Layers 1–2     | Ethernet, Wi-Fi |

### OSI vs TCP/IP

```text
OSI Model                    TCP/IP Model

7. Application ─┐
6. Presentation ├────────→ Application
5. Session ─────┘

4. Transport ────────────→ Transport

3. Network ──────────────→ Internet

2. Data Link ─┐
1. Physical ──┴──────────→ Network Access / Link
```

> **OSI → 7 layers**
> **TCP/IP → commonly represented as 4 layers**

---

# What Happens When You Type `google.com` Into a Browser?

This is one of the most common **Computer Networks interview questions**.

When you enter:

```text
https://google.com
```

the browser performs several steps involving **DNS, networking, TLS, HTTP, and browser rendering**.

A simplified flow is:

```text
Browser
   ↓
DNS Resolution
   ↓
IP Address
   ↓
Connection Establishment
   ↓
TLS Handshake
   ↓
HTTP Request
   ↓
Server Processing
   ↓
HTTP Response
   ↓
Browser Rendering
```

---

## Step 1: DNS Resolution

The browser needs an IP address corresponding to `google.com`.

It may first check various local caches, such as:

* Browser DNS cache.
* Operating system DNS cache.
* Local network/router cache.

If the address is not cached, the configured **DNS resolver** performs the necessary DNS lookups.

Conceptually, this may involve:

```text
DNS Resolver
     ↓
Root DNS Servers
     ↓
.com TLD DNS Servers
     ↓
Authoritative DNS Servers
     ↓
IP Address
```

The result might be an IPv4 or IPv6 address.

> **DNS converts a domain name into an IP address.**

---

# Step 2: Establishing a Connection

For traditional HTTPS over TCP, the client establishes a TCP connection with the server.

TCP uses a **three-way handshake**:

### 1. SYN

The client sends a **SYN** packet to request a TCP connection.

### 2. SYN-ACK

The server responds with **SYN-ACK**.

### 3. ACK

The client sends an **ACK**.

```text
Client                         Server

  | -------- SYN ------------> |
  | <------ SYN + ACK -------- |
  | -------- ACK ------------> |

        TCP Connection
        Established
```

> **TCP handshake → SYN → SYN-ACK → ACK**

### Important Modern Note

Not every modern HTTPS connection uses TCP. **HTTP/3 uses QUIC over UDP**, so the connection-establishment process differs from the traditional TCP + TLS flow.

---

# Step 3: TLS Handshake

Because HTTPS is being used, the connection must be secured.

The **TLS handshake** allows the client and server to:

* Negotiate cryptographic parameters.
* Authenticate the server using its certificate.
* Establish shared keys for encrypted communication.

After the handshake, application data can be exchanged securely.

```text
Client
  ↓
TLS Handshake
  ↓
Server Authentication
  ↓
Session Keys Established
  ↓
Encrypted Communication
```

> **HTTPS = HTTP secured using TLS.**

---

# Step 4: Sending the HTTP Request

The browser sends an HTTP request to the server.

A simplified request looks like:

```http
GET / HTTP/1.1
Host: google.com
```

The actual request can contain many additional headers, cookies, and other information.

For HTTP/2 and HTTP/3, the wire representation differs from the simple HTTP/1.1 text format, but the browser is still making an HTTP request.

---

# Step 5: Server Processing

The request reaches Google's infrastructure.

A simplified flow might look like:

```text
Browser
   ↓
Network
   ↓
Load Balancer / Edge Infrastructure
   ↓
Application Servers
   ↓
Backend Services / Databases
```

The server processes the request and sends an HTTP response.

A simplified response could contain:

```http
HTTP/1.1 200 OK
Content-Type: text/html
```

The response may contain:

* HTML.
* CSS.
* JavaScript.
* Images.
* Fonts.
* Other resources.

> **200 OK** means the HTTP request was successfully processed.

---

# Step 6: Browser Rendering

The browser receives the response and begins processing it.

For an HTML page, the browser approximately:

```text
HTML
 ↓
DOM
 ↓
CSS
 ↓
CSSOM
 ↓
Render Tree
 ↓
Layout
 ↓
Paint
 ↓
Display
```

The browser may also discover additional resources such as:

* CSS files.
* JavaScript files.
* Images.
* Fonts.

It requests these resources as necessary and continues rendering the page.

---

# Complete Interview Flow

When asked:

> **"What happens when you type `google.com` in the browser?"**

A good concise answer is:

```text
1. Browser checks DNS caches.
2. DNS resolves google.com to an IP address.
3. A connection is established with the server.
4. For HTTPS over TCP, TCP performs a three-way handshake.
5. TLS establishes secure encrypted communication.
6. Browser sends an HTTP request.
7. Server processes the request and sends an HTTP response.
8. Browser receives the resources and renders the webpage.
```
