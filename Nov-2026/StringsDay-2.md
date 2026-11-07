# Strings
---

##### Find the longest common prefix.

```java
class Solution {
    public String longestCommonPrefix(String arr[]) {
        StringBuilder res = new StringBuilder();
        int minLen = arr[0].length();
        
        for(String str : arr)
            minLen = Math.min(minLen, str.length());
            
        for(int i = 0; i < minLen; i++)
        {
            char ch = arr[0].charAt(i);
            
            for(String str : arr)
                if(str.charAt(i) != ch)
                    return res.toString();
                    
            res.append(ch);
        }
        
        return res.toString();
    }
}
```
---

##### Longest substring without repeating characters.

```java
class Solution {
    public int longestUniqueSubstr(String s) {
      if(s.length() <= 1)
        return s.length();
      
      boolean vis[] = new boolean[26];
      
      int left = 0, right = 0;
      int res = 0;
      while(right < s.length())
      {
          while(vis[s.charAt(right) - 'a'] == true)
          {
              vis[s.charAt(left) - 'a'] = false;
              left++;
          }
          
          vis[s.charAt(right) - 'a'] = true;
          res = Math.max(res, right - left + 1);
          right++;
      }
      
      return res;
    }
}
```
```java
class Solution {
    public int longestUniqueSubstr(String s) {
      HashMap<Character,Integer> check = new HashMap<>();
      int maxLen = 0;
      int start = 0;
      
      for(int end = 0; end < s.length(); end++)
      {
          char ch = s.charAt(end);
          
          if(check.containsKey(ch) && check.get(ch) >= start)
            start = check.get(ch)+1;
            
        check.put(ch,end);
        
        int windowLen = end - start + 1;
        if(windowLen > maxLen)
            maxLen = windowLen;
      }
      
      return maxLen;
    }
}
```
---

##### Group anagrams.

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> vals = new HashMap<>();

        for(String s : strs)
        {
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            if(!vals.containsKey(key))
                vals.put(key, new ArrayList<>());
            
            vals.get(key).add(s);
        }

        List<List<String>> res = new ArrayList<>();

        for(List<String> group: vals.values())
            res.add(group);

        return res;
    }
}
```
---