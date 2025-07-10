import java.util.HashSet;
import java.util.Iterator;

public class Hashing {

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        //adding the elements

        set.add(1);
        set.add(2);
        set.add(4);
        set.add(0);
        set.add(2);

        System.out.println("Size: " + set.size());
        System.out.println(set);
        //search an element
        if(set.contains(2))
            System.out.println("set contains the element");
        
        //remove
        set.remove(2);
        System.out.println(set);
        if (!set.contains(2)) 
            System.out.println("set doesn't contain that element");


        Iterator i = set.iterator();

        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();
    }
}
