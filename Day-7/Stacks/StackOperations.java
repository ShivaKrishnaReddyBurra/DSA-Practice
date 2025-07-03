import java.util.Scanner;
import java.util.Stack;

class StackOperations{

    public static void main(String args[]){
        Stack<Integer> stackArray = new Stack<Integer>();
        Scanner scanner = new Scanner(System.in);
        
        for(int i = 0; i < 5; i++)
            stackArray.push(scanner.nextInt());
        
        scanner.close();
        
        System.out.print(stackArray + "\n");

        System.out.println("peek: "+ stackArray.peek());

        System.out.println("pop: "+ stackArray.pop());

        System.out.println("search: " + stackArray.search(5));
    }
}