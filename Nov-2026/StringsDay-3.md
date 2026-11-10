# Strings
---

##### Check whether one string is a subsequence of another.

```java
class Solution {
    public boolean isSubSeq(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        
        if(n > m)
            return false;
            
        int i = 0, j = 0;
        
        while(i < n && j < m)
        {
            if(s1.charAt(i) == s2.charAt(j))
                i++;
            j++;
        }
        
        return i == n;
    }
}
```
---

##### Find the longest palindromic substring.

```java
class Solution {
    public String getLongestPal(String s) {
        
        int maxLen = 1, start = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            for(int j = i; j < s.length(); j++)
            {
                if(valPal(s, i, j) && (j - i + 1) > maxLen)
                {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        
        return s.substring(start, start + maxLen);
        
    }
    
    public boolean valPal(String s, int left, int right)
    {
        while(left < right)
        {
            if(s.charAt(left) != s.charAt(right))
                return false;
            
            left++;
            right--;
        }
        
        return true;
    }
}
```