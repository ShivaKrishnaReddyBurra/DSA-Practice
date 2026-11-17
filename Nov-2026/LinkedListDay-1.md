# Linked List
---

##### Create and display a singly linked list.
```java
class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class Solution{

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
```
---

##### Insert a node at the beginning.
```java
class Solution {
    public Node insertAtFront(Node head, int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        
        return newNode;
    }
}
```
---

##### Insert a node at the end.
```java
class Solution {
    public Node insertAtEnd(Node head, int x) {
        Node newNode = new Node(x);
        
        if(head == null)
            return newNode;
        
        Node curr = head;
        
        while(curr.next != null)
            curr = curr.next;
            
        curr.next = newNode;
        
        return head;
    }
}
```
---

##### Insert a node at a specific position.
```java
class Solution {
    public Node insertPos(Node head, int pos, int val) {
        int indx = 1;
        Node newNode = new Node(val);
        
        if(pos == 1)
        {
            newNode.next = head;
            return newNode;
        }
        
        Node curr = head;
        
        while(curr != null && indx < pos - 1)
        {
            curr = curr.next;
            indx++;
        }
        
        
        if(curr == null)
            return head;
            
        newNode.next = curr.next;
        curr.next = newNode;
        
        return head;
    }
}
```
---

##### Delete the first node
```java
class Solution {
    public Node deleteHead(Node head) {
        
        if(head == null)
            return null;
        
        head = head.next;
        
        return head;
    }
}
```
---

##### Delete the last node.
```java
class Solution {
    public Node removeLastNode(Node head) {
        
        if(head == null || head.next == null)
            return null;
        
        Node curr = head;
        
        while(curr.next.next != null)
            curr = curr.next;
            
        curr.next = null;
        
        return head;
    }
}
```
---

##### Delete a node by value.
```java
class Solution {
    Node deleteNode(Node head, int x) {
        
        if(head == null)
            return null;
        
        if(x == 1)
            return head.next;
        
        Node temp = head;
        Node prev = null;
        
        for(int i = 1; i < x; i++)
        {
            prev = temp;
            temp = temp.next;
        }
        
        prev.next = temp.next;
        
        return head;
    }
}
```
---
##### Find the middle node.(Floyd's Tortoise and Hare Algorithm)
```java
class Solution {
    int getMiddle(Node head) {
        Node slowPtr = head;
        Node fastPtr = head;
        
        while(fastPtr != null && fastPtr.next != null)
        {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        
        return slowPtr.data;
    }
}
```
---

##### Reverse a linked list.
```java
class Solution {
    Node reverseList(Node head) {
        Node curr = head, prev = null, next;
        
        while(curr != null)
        {
            next = curr.next; // setting to next node;
            curr.next = prev; // reversing curr node's next pointer
            
            
            // Move pointers one position ahead
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
```
---
