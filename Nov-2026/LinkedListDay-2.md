# Linked List
---

##### Find the Nth node from the end.
```java
class Solution {
    public int getKthFromLast(Node head, int k) {
      Node fast = head, slow = head;
      
      for(int i = 0; i < k; i++)
      {
          if(fast == null)
            return -1;
          fast = fast.next;
      }
      
      while(fast != null)
      {
          fast = fast.next;
          slow = slow.next;
      }
      
      return (slow != null) ? slow.data : -1;
    }
    
}
```
---

##### Remove duplicates from a sorted linked list
```java
class Solution {
    Node removeDuplicates(Node head) {
        Node curr = head;
        
        while(curr != null && curr.next != null)
        {
           if(curr.data == curr.next.data)
            curr.next = curr.next.next; //remove duplicate
           else
            curr = curr.next;
        }
        
        return head;
    }
}
```
---

##### Remove duplicates from an unsorted linked list.
```java
class Solution {
    public Node removeDuplicates(Node head) {
        HashSet<Integer> seen = new HashSet<>();
        Node curr = head, prev = null;
        
        while(curr != null)
        {
            if(seen.contains(curr.data))
                prev.next = curr.next;
            else
            {
                seen.add(curr.data);
                prev = curr;
            }
            
            curr = prev.next;
        }
        
        return head;
    }
}
```
---

##### Find the intersection point of two linked lists.
```java
class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        HashSet<Node> seen = new HashSet<Node>();
        
        Node curr = head1;
        
        while(curr != null)
        {
            seen.add(curr);
            curr = curr.next;
        }
        
        curr = head2;
        
        while(curr != null)
        {
            if(seen.contains(curr))
                return curr;
            
            curr = curr.next;
        }
        
        return null;
    }
}
```

```java
class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        Node ptr1 = head1, ptr2 = head2;
        
        while(ptr1 != ptr2)
        {
            ptr1 = (ptr1 != null) ? ptr1.next : head2;
            ptr2 = (ptr2 != null) ? ptr2.next : head1;
        }
        
        return ptr1;
    }
}
```
---

##### Detect a cycle in a linked list.
```java
class Solution {
    public boolean detectLoop(Node head) {
        HashSet<Node> seen = new HashSet<>();
        
        Node curr = head;
        while(curr != null)
        {
            if(seen.contains(curr))
                return true;
            
            seen.add(curr);
            curr = curr.next;
        }
        
        return false;
    }
}
```
```java 
class Solution {
    public boolean detectLoop(Node head) {
       Node slow = head, fast = head;
       
       while(slow != null && fast != null && fast.next != null)
       {
           slow = slow.next;
           fast = fast.next.next;
           
           if(slow == fast)
            return true;
       }
       
       return false;
    }
}
```
---

##### Find the starting point of a cycle.
class Solution {
    public int cycleStart(Node head) {
        HashSet<Node> seen = new HashSet<>();
        
        while(head != null)
        {
            if(seen.contains(head))
                return head.data;
            
            seen.add(head);
            head = head.next;
        }
        
        return -1;
    }
}

```java
class Solution {
    public int cycleStart(Node head) {
        Node slow = head, fast = head;
        
        while(slow != null && fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) // loop detected 
            {
                slow = head;
                
                while(slow != fast)
                {
                    slow = slow.next;
                    fast = fast.next;
                }
                
                return slow.data;
            }
        }
        
        return -1;
    }
}
```
---

##### Remove a cycle from a linked list.
```java
class Solution {
    public static void removeLoop(Node head) {
        HashSet<Node> seen = new HashSet<>();
        
        Node curr = head;
        Node prev = null;
        
        while(curr != null)
        {
            if(seen.contains(curr))
            {
                prev.next = null;
                break;
            }
            
            seen.add(curr);
            prev = curr;
            curr = curr.next;
        }
    }
}
```
---
