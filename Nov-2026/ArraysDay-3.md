# Arrays
---

##### Merge two sorted arrays into one sorted array

```java
class Solution {
    public void mergeArrays(int a[], int b[]) {
        int i = 0, j = 0, k = 0;
        
        int temp[] = new int[a.length + b.length];
        
        while(i < a.length && j < b.length)
        {
            if(a[i] <= b[j])
                temp[k++] = a[i++];
            else
                temp[k++] = b[j++];
        }
        
        // copy remaining from a
        while(i < a.length) temp[k++] = a[i++];
        
        // copy remaining from b
        while(j < b.length) temp[k++] = b[j++];
        
        for(i = 0; i < a.length; i++)
            a[i] = temp[i];
            
        for(j = 0; j < b.length; j++)
            b[j] = temp[j+a.length];
    }
}
```
---

##### Find the intersection of two arrays.

```java
class Solution {
    public ArrayList<Integer> intersect(int[] a, int[] b) {
        HashSet<Integer> check = new HashSet<>();
        
        for(int i = 0; i < a.length; i++)
            check.add(a[i]);
            
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < b.length; i++)
            if(check.remove(b[i]))
                res.add(b[i]);
                
        return res;
                
    }
}
```
---

##### Find the majority element (appears more than n/2 times).

```java
class Solution {
    int majorityElement(int arr[]) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for(int i : arr)
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        
        for(int key: freq.keySet())
        {
            if(freq.get(key) > arr.length/2)
                return key;
        }
            
            
        return -1;
    }
}
```
---

##### Find the pair of elements whose sum is closest to a given target.

```java
class Solution {
    public ArrayList<Integer> sumClosest(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int minDiff = Integer.MAX_VALUE;
        
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(arr);
        
        while(left < right)
        {
            int currSum = arr[left] + arr[right];
            
            if(Math.abs(target - currSum) < minDiff)
            {
                minDiff = Math.abs(target - currSum);
                res.clear();
                res.add(arr[left]);
                res.add(arr[right]);
            }
            
            if(currSum < target)
                left++;
            else if(currSum > target)
                right--;
            else
                return res;
        }
        
        return res;
    }
}
```
---