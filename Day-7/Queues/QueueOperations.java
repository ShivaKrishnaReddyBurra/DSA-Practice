import java.util.Queue;
import java.util.Scanner;
import java.util.PriorityQueue;

public class QueueOperations {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Queue<Integer> queueArray = new PriorityQueue<Integer>();
    

    for(int i = 0; i < 5; i++)
        queueArray.add(scanner.nextInt());
    
    scanner.close();
    System.out.println(queueArray);

    System.out.println("peek: "+ queueArray.peek());

    System.out.println("remove: "+ queueArray.remove());
  }
}
