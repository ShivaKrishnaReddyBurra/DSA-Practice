# Searching and Sorting
---

##### Implement Merge Sort.
```java
class Solution {
    public void mergeSort(int arr[], int l, int r) {
        
        if(l < r)
        {
            int m = l + (r - l) / 2;
            
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            
            merge(arr, l, m, r);
        }
    }
    
    public static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1; // size for temp arr1
        int n2 = r - m; // size for temp arr2
        
        int temp1[] = new int[n1];
        int temp2[] = new int[n2];
        
        for(int i = 0; i < n1; i++)
            temp1[i] = arr[l+i];
            
        for(int j = 0; j < n2; j++)
            temp2[j] = arr[m + 1 + j];
        
        int i = 0, j = 0; // indx for temp arr
        
        int k = l; // indx for arr
        
        while(i < n1 && j < n2)
        {
            if(temp1[i] < temp2[j])
                arr[k++] = temp1[i++];
            else
                arr[k++] = temp2[j++];
        }
        
        while(i < n1)
            arr[k++] = temp1[i++];
            
        while(j < n2)
            arr[k++] = temp2[j++];
        
    }
}
```
---

##### Implement Quick Sort.
```java
class Solution {
    public void quickSort(int[] arr, int low, int high) {
        if(low < high)
        {
            int pi = partition(arr, low, high);
            
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        
        int i = low - 1;
        
        for(int j = low; j <= high -1; j++)
        {
            if(arr[j] < pivot)
            {
                i++;
                swap(arr,i , j);
            }
        }
        
        swap(arr, i + 1, high); // pivot element is getting swaped
        
        return i + 1;
    }
    
    public static void swap(int arr[], int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```
---

##### Search in a 2D sorted matrix.
```java
class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length, m = mat[0].length;
        
        int low = 0, high = n * m - 1;
        
        while(low <= high)
        {
            int mid = (high + low) / 2;
            
            int row = mid / m;
            int col = mid % m;
            
            if(mat[row][col] == x)
                return true;
            else if (mat[row][col] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return false;
    }
}
```
---

##### Find the minimum element in a rotated sorted array
```java
class Solution {
    public int findMin(int[] arr) {
        int low = 0, high = arr.length - 1;
        
        while(low < high)
        {
            if(arr[low] < arr[high])
                return arr[low];
                
            int mid = (low + high) / 2;
            
            if(arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }
        
        return arr[low];
    }
}
```
---

##### Find the number of rotations in a sorted array.
```java
class Solution {
    public int findKRotation(int arr[]) {
        int low = 0 , high = arr.length - 1;
        
        while(low < high)
        {
            if(arr[low] < arr[high])
                return low;
            
            int mid = (low + high) / 2;
            
            if(arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }
        
        return low;
    }
}
```
---
