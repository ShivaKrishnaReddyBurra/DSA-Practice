public class SubSequencesInString {
    public static void subSequences(String s, int index, String newString)
    {
        if(index == s.length())
        {
            System.out.println(newString);
            return;
        }
        
        char currentChar = s.charAt(index); 
        
        subSequences(s, index+1, newString+currentChar);

        subSequences(s, index+1, newString);
    }
    public static void main(String[] args) {
        String s = "abcd";
        subSequences(s, 0, "");
    }    
}
