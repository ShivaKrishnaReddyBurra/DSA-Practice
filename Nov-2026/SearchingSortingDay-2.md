# Searching and Sorting
---

##### Implement Bubble Sort
```java
class Solution {
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        for(int i = 0; i < n - 1; i++)
        {
            swapped = false;
            for(int j = 0; j < n - i - 1; j++)
            {
                if(arr[j] > arr[j + 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            if(!swapped)
                break;
        }
    }
}
```
---

##### Implement Selection Sort
```java
class Solution {
    void selectionSort(int[] arr) {
        int n = arr.length;
        
        for(int i = 0; i < n - 1; i++)
        {
            int minIdx = i;
            for(int j = i + 1; j < n; j++)
                if(arr[j] < arr[minIdx])
                    minIdx = j;
            
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
}
```
---

##### Implement Insertion Sort
```java
class Solution {
    public void insertionSort(int arr[]) {
        int n = arr.length;
        
        for(int i = 1;  i < n; i++)
        {
            int key = arr[i];
            int j = i - 1;
            
            while(j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = key;
        }
    }
}
```
---

