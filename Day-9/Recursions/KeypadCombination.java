public class KeypadCombination {

    public static void printCOmbinations(String s, int index, String keypad[], String combination)
    {
        if(index == s.length())
        {
            System.out.println(combination);
            return;
        }

        char currentChar = s.charAt(index);
        String map = keypad[currentChar-'0'];

        for(int i = 0; i < map.length(); i++)
        {
            printCOmbinations(s, index+1, keypad, combination+map.charAt(i));
        }
    }
    public static void main(String[] args) {
        String keypad[] = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
        String s ="21";
        printCOmbinations(s, 0, keypad, "");

    }
}