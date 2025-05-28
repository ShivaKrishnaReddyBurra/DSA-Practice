import java.util.Scanner;
public class MergeSort {
    static void merge(int arr[], int low, int high, int mid)
    {
        int leftArraySize = mid - low + 1;
        int rightArraySize = high - mid;

        int leftArray[] = new int[leftArraySize];
        int rightArray[] = new int[rightArraySize];

        for(int i = 0; i < leftArraySize; i++)
            leftArray[i] = arr[low+i];
        for(int i = 0; i < rightArraySize; i++)
            rightArray[i] = arr[mid+i+1];
        
        int i = 0, j = 0, k = low;
        
        while(i < leftArraySize && j < rightArraySize)
        {
            if(leftArray[i] <= rightArray[j])
            {
               arr[k] = leftArray[i];
               i++;
            }
            else
            {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        for(; i < leftArraySize; i++, k++)
            arr[k] = leftArray[i];
        
        for(; j < rightArraySize; j++, k++)
            arr[k] = rightArray[j];
    }

    static void sort(int arr[], int low, int high)
    {
        if(low < high)
        {
            int mid = low + (high - low)/2;
            sort(arr, low, mid);
            sort(arr, mid+1, high);
            merge(arr, low, high, mid);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int arr[] = new int[size];
        for(int i = 0; i < size; i++)
            arr[i] = scanner.nextInt();
        scanner.close();
        sort(arr, 0, size -1);
        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }
}
