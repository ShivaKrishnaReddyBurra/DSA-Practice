# Strings
---

##### Reverse a string

```java
class Solution {
    public static String reverseString(String s) {
        if(s.length() <= 1)
            return s;
        
        char chars[] = s.toCharArray();
        
        int left = 0;
        int right = chars.length - 1;
        
        while(left < right)
        {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            
            left++;
            right--;
        }
        
        return new String(chars);
        
    }
}
```

```java
class Solution {
    public static String reverseString(String s) {
        int left = 0, right = s.length() - 1;
            
        StringBuilder res = new StringBuilder(s);
    
    
        while (left < right) {
            char temp = res.charAt(left);
            res.setCharAt(left, res.charAt(right));
            res.setCharAt(right, temp);
            left++;
            right--;
        }
    
        return res.toString();
        
    }
}
```
---

##### Check whether a string is a palindrome.

```java
class Solution {
    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right)
        {
            if(s.charAt(left) != (s.charAt(right)))
                return false;
                
            left++;
            right--;
        }
        
        return true;
    }
}
```
---

##### Count the number of words in a string

```java
class Solution {
    public int countWords(String s) {
        String words[] = s.trim().split("\\s+");
        
        return words.length;
    }
}
```
---

##### Check whether two strings are anagrams.

```java
class Solution {
    public static boolean areAnagrams(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        
        HashMap<Character, Integer> charCount =
                                    new HashMap<>();

        // count frequency of each
        // character in string s1
        for (char ch : s1.toCharArray()) 
            charCount.put(ch,
                    charCount.getOrDefault(ch, 0) + 1);

        // count frequency of each
        // character in string s2
        for (char ch : s2.toCharArray()) 
            charCount.put(ch,
                    charCount.getOrDefault(ch, 0) - 1);

        // check if all frequencies are zero
        for (var pair : charCount.entrySet()) {
            if (pair.getValue() != 0) {
                return false;
            }
        }
            
        return true;
    }
}
```
---

##### Find the first non-repeating character.

```java
class Solution {
    public char nonRepeatingChar(String s) {
       HashMap<Character, Integer> freq = new HashMap<>();
       
       for(int i = 0; i< s.length(); i++)
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
            
       for(int i = 0; i < s.length(); i++)
       {
           if(freq.get(s.charAt(i)) == 1)
            return s.charAt(i);
       }
       
       return '$';
    }
}
```
---
##### Remove duplicate characters.

```java
class Solution {
    String removeDuplicates(String s) {
       LinkedHashSet<Character> val = new LinkedHashSet<>();
        
        for(char ch : s.toCharArray())
                val.add(ch);
                
        StringBuilder res = new StringBuilder();
        
        for(char ch : val)
            res.append(ch);
            
        return res.toString();
    }
}
```
---
