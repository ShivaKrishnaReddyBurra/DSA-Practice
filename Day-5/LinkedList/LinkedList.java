class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class LinkedList {
    
    static void traverse(Node head) // printing all the elements in the linked list
    {
        while(head != null)
        {
            System.out.print(head.data+" --> ");
            head=head.next;
        }
        System.out.println();
    }

    static Node insertAtBeginning(Node head, int newData) 
    {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
        System.out.println(newData+" is added at front");
        return head;
    }

    static Node insertAtEnd(Node head, int newData)
    {
        Node newNode = new Node(newData);
        
        if(head == null)
            return newNode;

        Node current = head;
        while(current.next != null)
        {
            current = current.next;    
        }
        current.next = newNode;
        
        System.out.println(newData +" is added at the end");
        return head;
    }

    static Node insertAtParticularPostion(Node head, int newData, int position)
    {
        if(head == null && position < 1)
        {
            System.out.println("List is empty so try adding element at first postion");
            return head;
        }

        Node newNode = new Node(newData);

        if(position == 1)
        {
            head = insertAtBeginning(head, newData);
            return head;
        }

        Node currentNode = head;

        for(int i = 1; i < position - 1 && currentNode != null; i++)
        {
            currentNode = currentNode.next;
        }
        if(currentNode == null)
        {
            System.out.println("We can't insert at non-existing postion");
            return head;
        }

        newNode.next = currentNode.next;
        currentNode.next = newNode;
        System.out.println(newData+" is added at the postion "+ position);
        return head;
    }

    static Node deleteAtStart(Node head)
    {
        if(head == null)
        {
            System.out.println("List is empty so can't delete at front");
            return head;
        }
        head = head.next;
        System.out.println("Deleted at front");
        return head;        
    }
    static Node deleteAtEnd(Node head)
    {
        if(head == null)
        {
            System.out.println("List is empty so can't delete at front");
            return head;
        }
        Node currentNode = head;
        while (currentNode.next.next != null) 
            currentNode = currentNode.next;
        currentNode.next = null;
        System.out.println("Deleted node at End");
        return head;
    }

    static Node deleteAtParticularPosition(Node head, int postion)
    {
        if(head == null)
        {
            System.out.println("List is empty so can't delete at front");
            return head;
        }
        Node currentNode = head;
        Node perviousNode = null;
        if(postion == 1)
        {
            head = currentNode.next;
            System.out.println("Deleted Node at position " + postion);
            return head;
        }
        
        for(int i = 1; i < postion && currentNode != null;i++)
        {
            perviousNode = currentNode;
            currentNode = currentNode.next;
        }
            
        if(currentNode != null)
        {
            perviousNode.next = currentNode.next;
            System.out.println("Deleted Node at position " + postion);
            return head;
        }
        else{
            System.out.println("No data at that "+ postion +" position to delete");
            return head;
        }
    }

    public static void main(String[] args) {
        Node head = insertAtParticularPostion(null, 0,1 );
        head = insertAtParticularPostion(head, 1, 2);
        head = insertAtBeginning(head, 3);
        head = insertAtEnd(head, 4);
        traverse(head);
        head = deleteAtStart(head);
        traverse(head);
        head = deleteAtEnd(head);
        traverse(head);     
        head = deleteAtParticularPosition(head, 2);
        traverse(head);   
    }
}
