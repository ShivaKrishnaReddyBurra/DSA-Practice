class Node{
    Node children[] = new Node[26];
    boolean eow;

    Node()
    {
        for(int i = 0; i < 26; i++)
            children[i] = null;
    }
}

public class Trie {

    public static Node root = new Node();

    public static void insert(String word)
    {
        Node curr = root;
        for(int i = 0; i < word.length(); i++)
        {
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null)
                curr.children[index] = new Node();
            
            if(i == word.length() - 1)
                curr.eow = true;
            
            curr = curr.children[index];
        }
    }

    public static boolean search(String word)
    {
        Node curr = root;
        for(int i = 0; i < word.length(); i++)
        {
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null)
                return false;
            
            if(i == word.length() - 1 && curr.eow == false)
                return false;
            
            curr = curr.children[index];
        }
        return true;
    }
    public static boolean wordBreak(String key)
    {
        if(key.length() == 0)
            return true;
        for(int i = 1; i <= key.length(); i++)
        {
            String firstPart = key.substring(0, i);
            String secondPart = key.substring(i);
            
            if(search(firstPart) && wordBreak(secondPart))
                return true;
        }
        return false;
    }

    public static boolean startsWith(String prefix)
    {
        Node curr = root;
        for(int i = 0; i < prefix.length(); i++)
        {
            int index = prefix.charAt(i) - 'a';
            if(curr.children[index] == null)
                return false;
            
            curr = curr.children[index];
        }
        return true;
    }
    public static void main(String[] args) {

        String words[] = {"the", "a", "there", "their", "any"};

        for(int i = 0; i < words.length; i++)
            insert(words[i]);

        System.out.println(search("th"));
        if(search("the"))
            System.out.println("word exists");
        
        String key = "theany";
        System.out.println(wordBreak(key));

        System.out.println(startsWith("th"));


    }
    
}
