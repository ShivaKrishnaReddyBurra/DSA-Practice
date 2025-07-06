public class StringReverse {
    
    public static void printReverse(String s, int index)
    {
        if(index == 0)
        {
            System.out.println(s.charAt(index));
            return;
        }
        System.out.print(s.charAt(index));
        printReverse(s, index-1);
    }
    public static void main(String[] args) {
        String s = "SHIVA";
        printReverse(s, s.length()-1);
    }    
}
