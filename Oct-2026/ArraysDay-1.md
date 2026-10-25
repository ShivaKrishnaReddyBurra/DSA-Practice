# Arrays
***
##### Find the sum of all array elements.

```java
class Solution {
    public int arraySum(int arr[]) {
        // code here
        int sum = 0;
        for(int i : arr)
            sum += i;
            
        return sum;
    }
}
```

---

##### Find the largest element in an array.

```java
class Solution {
    public static int largest(int[] arr) {
        // code here
        int largest = Integer.MIN_VALUE;
        
        for(int i: arr)
            if(i > largest)
                largest = i;
                
        return largest;
    }
}
``` 
---

##### find even and odd numbers in an array.

```java
class Solution {
    public int[] countOddEven(int[] arr) {
        int evenCount = 0, oddCount = 0;
        
        for(int i : arr)
        {
            if(i % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }
        
        return new int[] {oddCount, evenCount};
    }
}
```
---
##### Reverse an array.

```java
class Solution {
    public void reverseArray(int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        
        while(left < right)
        {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
    }
}
```
---
##### Find the second largest element in an array.

```java
class Solution {
    public int getSecondLargest(int[] arr) {
        if(arr.length <= 1)
            return -1;
        
        int largest = Integer.MIN_VALUE;
        int secLargest = Integer.MIN_VALUE;
        
        for(int i: arr)
        {
            if(i > largest)
            {
                secLargest = largest;
                largest = i;
            }
            else if(i > secLargest && i < largest)
                secLargest = i;
        }
        
        if(secLargest == Integer.MIN_VALUE)
            return -1;
            
        return secLargest;
    }
}
```
---
##### Check if an array is sorted.

```java
class Solution {
    public boolean isSorted(int[] arr) {
        if(arr.length <= 1)
            return true;
        
        for(int i = 1; i < arr.length; i++)
            if(arr[i] < arr[i-1])
                return false;
                
        return true;
    }
}
```
---
##### move all zeros to the end of an array.

```java
class Solution {
    void pushZerosToEnd(int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] != 0)
            {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                
                count++;
            }
        }
    }
}
```
---
##### remove duplicates from a sorted array.

```java
class Solution {
    ArrayList<Integer> removeDuplicates(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        if(arr.length <= 0)
            return res;
            
        res.add(arr[0]);
        
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] != arr[i-1])
                res.add(arr[i]);
        }
        
        return res;
    }
}
```
---
##### two sum

```java
class Solution {
    boolean twoSum(int arr[], int target) {
        HashMap<Integer, Integer> check = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++)
        {
            if(check.containsKey(target - arr[i]))
                return true;
            
            check.put(arr[i], i);
        }
        
        return false;
    }
}
```
---
##### Find the maximum sum (Kadane's Algorithm)

```java
class Solution {
    int maxSubarraySum(int[] arr) {
        int maxSum = arr[0];
        int currSum = 0;
        
        for(int i : arr)
        {
            if(currSum < 0)
                currSum = 0;
                
            currSum += i;
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;
    }
}
```
---

##### rotate an array by k positions.

```java
class Solution {
    public void rotateclockwise(int[] arr, int k) {
        if (arr == null || arr.length == 0) return;
        
        k = k % arr.length;
        
        if(k == 0) return;
        
        int res[] = new int[arr.length];
        int i = 0;
        for(int m = arr.length -k; m < arr.length; i++,m++)
            res[i] = arr[m];
        
        for(int j = 0; j < arr.length - k; j++,i++)
            res[i] = arr[j];
        
        for(int l = 0; l < res.length; l++)
            arr[l] = res[l];
        
    }
}

class Solution {
    public void rotateclockwise(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return;

        k %= n;
        if (k == 0) return;

        reverse(arr, 0, n - 1);   // reverse whole array
        reverse(arr, 0, k - 1);   // reverse first k elements
        reverse(arr, k, n - 1);   // reverse remaining elements
    }

    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
```
---
##### find missing number in an array of size n containing numbers from 1 to n.

```java
class Solution {
    int missingNum(int arr[]) {
       int n = arr.length+1;
       long expSum = (long) n * (n+1)/2;
       
       int actSum = 0;
       for(int i : arr)
        actSum += i;
        
       return (int)expSum - actSum;
    }
}
```
---
##### best time to buy and sell stock.

```java
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for(int price : prices)
        {
            if(minPrice > price)
                minPrice = price;
                
            else if(price - minPrice > maxProfit)
                maxProfit = price - minPrice;
        }
        
        return maxProfit;
    }
}
```
---


