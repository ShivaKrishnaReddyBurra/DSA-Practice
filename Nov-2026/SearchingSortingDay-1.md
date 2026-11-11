# Searching and Sorting
---

##### Implement Binary Search
```java
class Solution {
    public int search(int arr[], int x) {
        int left = 0;
        int right = arr.length - 1;
        
        while(left <= right)
        {
            int mid = (left + right)/2;
            if(arr[mid] == x)
                return mid;
            else if(arr[mid] > x)
                right = mid -1;
            else
                left = mid + 1;
        }
        
        return -1;
    }
}
```
---

##### Find the first occurrence of an element.
```java
class Solution {
    public int firstSearch(int[] arr, int k) {
        int left = 0, right = arr.length - 1, ans = -1;
        
        while(left <= right)
        {
            int mid = (left + right)/2;
            
            if(arr[mid] == k)
            {
                ans = mid;
                right = right - 1;
            }
            else if(arr[mid] > k)
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return ans;
    }
}
```
---

##### Count occurrences of an element in a sorted array.
```java
class Solution {
    int countFreq(int[] arr, int target) {
        int firstOccr = firstOccr(arr, target);
        if(firstOccr == -1)
            return 0;
        int lastOccr = lastOccr(arr, target);
        
        if(lastOccr == firstOccr)
            return 1;
            
        return lastOccr - firstOccr + 1;
    }
    
    public static int firstOccr(int arr[], int target)
    {
        int left = 0, right = arr.length - 1, ans = -1;
        
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            
            if(arr[mid] == target)
            {
                ans = mid;
                right = mid - 1;
            }
            else if(arr[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return ans;
    }
    
     public static int lastOccr(int arr[], int target)
    {
        int left = 0, right = arr.length - 1, ans = -1;
        
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            
            if(arr[mid] == target)
            {
                ans = mid;
                left = mid + 1;
            }
            else if(arr[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return ans;
    }
}
```
---

