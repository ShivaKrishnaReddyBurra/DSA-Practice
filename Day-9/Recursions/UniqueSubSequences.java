import java.util.HashSet;

public class UniqueSubSequences {
    public static void uniqueSubSequences(String s, int index, String newString, HashSet<String> set)
    {
        if(index == s.length())
        {
            if(set.contains(newString))
                return;
            else{
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }
        
        char currentChar = s.charAt(index); 
        
        uniqueSubSequences(s, index+1, newString+currentChar, set);

        uniqueSubSequences(s, index+1, newString, set);
    }
    public static void main(String[] args) {
        String s = "sss";
        HashSet<String> set = new HashSet<String>();
        uniqueSubSequences(s, 0, "", set);
    }    
}
