public class PermutationsOfString {
    public static void printPermutations(String s, String permutation)
    {
        if(s.length() == 0)
        {
            System.out.println(permutation);
            return;
        }
        for(int i = 0; i < s.length(); i++)
        {
            char currentChar = s.charAt(i);
            String newString = s.substring(0, i) + s.substring(i+1);
            printPermutations(newString, permutation + currentChar);
        }
    }
    public static void main(String[] args) {
        
        String s = "abcd";
        printPermutations(s, "");
    }    
}
