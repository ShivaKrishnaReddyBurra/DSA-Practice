# Arrays
---

##### Find the second-smallest distinct element.

```java
class Solution {
    public ArrayList<Integer> minAnd2ndMin(int[] arr) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        
        for(int i : arr)
        {
            if(i < first)
            {
                second = first;
                first = i;
            }
            else if ( i < second && i > first)
                second = i;
        }
        
        return (second == Integer.MAX_VALUE) ? new ArrayList<>(Arrays.asList(-1)) : new ArrayList<>(Arrays.asList(first, second));
    }
}
```
---
##### Find all duplicate elements in an array.

```java
class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicate = new HashSet<>();
        
        for(int i : arr)
        {
            if(seen.contains(i))
                duplicate.add(i);
            else
                seen.add(i);
        }
        
        return (duplicate.size() == 0) ? new ArrayList<>() : new ArrayList<>(duplicate);
    }
}
```
---

##### Remove duplicates from an unsorted array.

```java
class Solution {
    static ArrayList<Integer> removeDuplicate(int arr[]) {
        HashSet<Integer> check = new HashSet<Integer>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i : arr)
        {
            if(!check.contains(i))
            {
                check.add(i);
                res.add(i);
            }
        }
        
        return res;
    }
}
```
---
