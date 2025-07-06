public class FirstAndLastOccuranceOfAnElement {
    public static void printFirstAndLastIndexOfElement(String s, int index, int firstOccranceIndex, int lastOccuranceIndex, char element)
    {
        if(s.length() == index)
        {
            System.out.println("Element first occured at index "+firstOccranceIndex+" and last occured at "+lastOccuranceIndex);
            return;
        }

        if(s.charAt(index) == element)
        {
            if(firstOccranceIndex == -1)
                firstOccranceIndex = index;
            else
                lastOccuranceIndex = index;
        }
        printFirstAndLastIndexOfElement(s, index+1, firstOccranceIndex, lastOccuranceIndex, element);
    }
    public static void main(String[] args) {
        String s = "abbbabbbabaaaada";
        printFirstAndLastIndexOfElement(s, 0, -1, -1, 'b');
    }    
}
