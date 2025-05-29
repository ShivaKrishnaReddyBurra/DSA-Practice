import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    static void binarySearch(int arr[], int key)
    {
        int low = 0, high = arr.length-1;
        while(low < high)
        {
            int mid = low + (high - low)/2;
            if(arr[mid] == key)
            {
                System.out.println("Element found");
                break;
            }
            else if(arr[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        if(low >= high)
            System.out.println("Element not found");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int arr[] = new int[size];
        for(int i = 0; i < size; i++)
            arr[i] = scanner.nextInt();
        int key = scanner.nextInt();
        scanner.close();
        Arrays.sort(arr);
        binarySearch(arr, key);
    }    
}
