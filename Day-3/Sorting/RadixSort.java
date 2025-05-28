import java.util.Scanner;
public class RadixSort {
    static void radixSort(int arr[], int size)
    {
        int maxDigit = getMax(arr,size);
        for(int exp = 1; maxDigit/exp > 0; exp *= 10)
            sort(arr,exp,size);
    }   
    static int getMax(int arr[], int size)
    {
        int maxElement = arr[0];
        for(int i = 0; i < size; i++)
            if(arr[i] > maxElement)
                maxElement = arr[i];
        return maxElement;
    }  
    static void sort(int arr[], int exp, int size)
    {
        int modifiedArray[] = new int[size];
        int radixArray[] = new int[10];
        
        for(int i = 0; i < 10; i++)
            radixArray[i] = 0;
        
        for(int i = 0; i < size; i++)
            radixArray[(arr[i]/exp)%10]++;

        for(int i = 1; i < 10; i++)
            radixArray[i] += radixArray[i-1];

        for(int i = size -1; i >= 0; i--)
        {
            modifiedArray[radixArray[(arr[i]/exp)%10] - 1] = arr[i];
            radixArray[(arr[i]/exp)%10]--;
        }
        for(int i = 0; i < size; i++)
            arr[i] = modifiedArray[i];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int arr[] = new int[size];
        for(int i = 0; i < size; i++)
            arr[i] = scanner.nextInt();
        scanner.close();
        radixSort(arr, size);
        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }   
}
