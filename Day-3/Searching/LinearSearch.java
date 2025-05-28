import java.util.Scanner;
public class LinearSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int arr[] = new int[size];
        
        for(int i = 0; i < size; i++)
            arr[i] = scanner.nextInt();

        int key = scanner.nextInt();
        scanner.close();
        Boolean flag = false;
        for(int i = 0; i < size; i++)
            if(key == arr[i]){
                System.out.print("Key found at index: " + i);
                flag = true;
                break;

            }
        if(!flag)
            System.out.print("Key not found");
    }    
}
