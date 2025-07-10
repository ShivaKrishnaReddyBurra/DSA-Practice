import java.util.HashSet;

public class IntersectionOfArrays {

    public static void intersection(int arr1[], int arr2[])
    {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr1.length; i++)
            set.add(arr1[i]);
        
        int count = 0;
        for(int i = 0; i < arr2.length; i++)
        {
            if(set.contains(arr2[i]))
            {
                count++;
                set.remove(arr2[i]);
            } 
        }

        System.out.println("total common elements are: " + count);


    }
    public static void main(String args[])
    {
        int arr1[] = {7,8,9};
        int arr2[] = {6,3,8,9,1,2,4,7};
        intersection(arr1, arr2);

    }
}
