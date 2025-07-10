import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hashing {
    
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>(); //<key,value>

        //adding the elements
        map.put(1, "S");
        map.put(2, "K");
        map.put(3, "R");
        map.put(4, "B");

        System.out.println(map);

        //check for key existence
        if(map.containsKey(3))
            System.out.println("value at the key-3: "+map.get(3)); // getting the value of key
        else
            System.out.println("key doesn't exist");
        

        for(Map.Entry<Integer, String> e : map.entrySet())
        {
            System.out.print(e.getKey() +": ");
            System.out.println(e.getValue());
        }

        Set<Integer> keys = map.keySet(); // making a set of keys
        for(int key: keys)
            System.out.print(key + ": " + map.get(key)+"\n");

        map.remove(4);
        System.out.println(map);

        
    }
}
