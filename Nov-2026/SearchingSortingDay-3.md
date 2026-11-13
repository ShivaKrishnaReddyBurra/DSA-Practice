# Searching and Sorting
---

##### Find the floor and ceiling of a target
```java
class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        int ceilDiff = Integer.MAX_VALUE;
        int floorDiff = Integer.MAX_VALUE;
        int ceilVal = -1, floorVal = -1;
        
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] >= x && ceilDiff > (arr[i] - x))
            {
                ceilDiff = arr[i] - x;
                ceilVal = arr[i];
            }
            
            if(arr[i] <= x && floorDiff > (x - arr[i]))
            {
                floorDiff = x - arr[i];
                floorVal = arr[i];
            }
        }
        
        return new int[] {floorVal, ceilVal};
    }
}
```
---

##### Search in a rotated sorted array.
```java
class Solution {
    int search(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        
        while(left <= right)
        {
            int mid = (left + right)/2;
            
            if(arr[mid] == key)
                return mid;
            else if(arr[mid] >= arr[left])
            {
                if(arr[left] <= key && key < arr[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else
            {
                if(arr[right] >= key && key > arr[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        
        return -1;
    }
}
```
---

