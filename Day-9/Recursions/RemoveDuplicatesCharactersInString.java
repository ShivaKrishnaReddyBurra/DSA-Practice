public class RemoveDuplicatesCharactersInString {

    public static void removeDuplicates(String s, int index, boolean map[], String newString)
    {
        if(index == s.length())
        {
            System.out.println(newString);
            return;
        }

        char currentChar = s.charAt(index);
        if(map[currentChar-'a'])
            removeDuplicates(s, index+1, map, newString);
        else{
            newString += currentChar;
            map[currentChar-'a'] = true;
            removeDuplicates(s, index+1, map, newString);
        }
            
    }
    public static void main(String[] args) {
        boolean map[] = new boolean[26];
        String s = "aavdhdhagjhsggsfgavnvb";
        removeDuplicates(s, 0, map, "");
    }
}
