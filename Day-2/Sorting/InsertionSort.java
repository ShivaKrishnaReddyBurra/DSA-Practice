import java.util.Scanner;
public class InsertionSort {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int arr[] = new int[size];
        for(int i = 0; i < size; i++)
            arr[i] = scanner.nextInt();
        scanner.close();
        for(int i = 1; i < size; i++){
            int key = arr[i];
            int j = i - 1;
            for(;j >= 0 && key < arr[j]; j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = key; 
        }
        for(int i : arr)
            System.out.print(i + " ");
    }
}
