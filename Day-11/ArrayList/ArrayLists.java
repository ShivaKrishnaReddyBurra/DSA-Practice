import java.util.ArrayList;
import java.util.Collections;

public class ArrayLists {

    public static void main(String args[])
    {
        ArrayList<Integer> list = new ArrayList<>();
        
        //adding
        list.add(0);
        list.add(1);
        list.add(5);
        System.out.println(list);

        //getting an element
        int element = list.get(2);
        System.out.println(element);

        //adding at particular index
        list.add(1,6);
        System.out.println(list);

        //setting an element
        list.set(0,8);
        System.out.println(list);
        

        //removing an element
        list.remove(2);
        System.out.println(list);

        //sorting
        Collections.sort(list);
        System.out.println(list);
    }
}
