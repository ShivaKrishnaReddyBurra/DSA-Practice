class Node{
    int data;
    Node previous, next;

    Node(int data)
    {
        this.data = data;
        previous = next = null;
    }
}

public class DoublyLinkedList {
    
    static void forwardTraverse(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data +" --> ");
            head = head.next;
        }
        System.out.println();
    }

    static void backwardTraverse(Node head)
    {
        Node currentNode = head;

        // Traverse to the last node
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }

        // Traverse backward from the last node
        while(currentNode != null) {
            System.out.print(currentNode.data + " --> ");
            currentNode = currentNode.previous;
        }
        System.out.println();
    }

    static Node insertAtBeginning(Node head, int data)
    {
        Node newNode = new Node(data);
        
        newNode.next = head;
        if(head != null)
            head.previous = newNode;
        
        return newNode;
    }

    static Node insertAtEnd(Node head, int data)
    {
        Node newNode = new Node(data);
        
        if(head == null)
            head = newNode;
        else
        {
            Node currenNode = head;
            while(currenNode.next != null)
                currenNode = currenNode.next;
            currenNode.next = newNode;
            newNode.previous = currenNode;
        }
        return head;
    }

    static Node insertAtParticularPosition(Node head, int data, int position)
    {
        Node newNode = new Node(data);
        
        if(position == 1)
            insertAtBeginning(head, data);
        
        Node currentNode = head;

        for(int i = 1; i < position -1 && currentNode != null; i++)
            currentNode = currentNode.next;

        if(currentNode == null)
        {
            System.out.println("Invalid position to add the data");
            return head;
        }

        newNode.previous = currentNode;
        newNode.next = currentNode.next;
        currentNode.next = newNode;

        if(newNode.next != null)
            newNode.next.previous = newNode;
        
        return head;
    }

    static Node deleteAtBeginning(Node head)
    {
        if(head == null)
        {
            System.out.println("list is empty can't delete");
            return head;
        }
        
        head = head.next;

        if(head != null)
            head.previous = null;
        
        System.out.println("Deleted node at the front");
        return head;
    }

    static Node deleteAtEnd(Node head)
    {
        if(head == null)
        {
            System.out.println("list is empty can't delete");
            return head;
        }
        
        if(head.next == null)
        {
            System.out.println("Deleted node at the end");
            return null;
        }

        Node currentNode = head;
        
        while(currentNode.next != null)
            currentNode = currentNode.next;
        
        if(currentNode.previous != null)
            currentNode.previous.next = null;

        System.out.println("Deleted node at the end");
        return head;
    }

    static Node deleteAtParticularPosition(Node head, int position)
    {
        if(head == null)
        {
            System.out.println("list is empty can't delete");
            return head;
        }
        
        Node currentNode = head;

        for(int i = 1; i < position && currentNode != null; i++)
            currentNode = currentNode.next;
        
        if(currentNode == null)
        {
            System.out.println("Invalid position to delete");
            return head;
        }

        if(currentNode.previous != null)
            currentNode.previous.next = currentNode.next;
        
        if(currentNode.next != null)
            currentNode.next.previous = currentNode.previous;
        
        if(currentNode == head)
            head = currentNode.next;
        
        System.out.println("Deleted Node at position " + position);
        return head;
    }
    public static void main(String[] args) {
        Node head = new Node(0);
        Node second = new Node(1);
        Node third = new Node(2);
        Node fourth = new Node(3);
        
        head.next = second;
        second.next = third;
        second.previous = head;
        third.next = fourth;
        third.previous = second;
        fourth.previous = third;

        forwardTraverse(head);
        backwardTraverse(head);

        head = insertAtBeginning(head, 4);
        forwardTraverse(head);
        head = insertAtEnd(head, 5);
        forwardTraverse(head);
        head = insertAtParticularPosition(head, 6, 3);
        forwardTraverse(head);
        head = deleteAtBeginning(head);
        forwardTraverse(head);
        head = deleteAtEnd(head);
        forwardTraverse(head);
        head = deleteAtParticularPosition(head, 10);
        forwardTraverse(head);
        head = deleteAtParticularPosition(head, 4);
        forwardTraverse(head);
    }
}
