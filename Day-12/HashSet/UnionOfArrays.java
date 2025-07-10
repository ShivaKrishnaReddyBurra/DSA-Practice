import java.util.HashSet;

public class UnionOfArrays {

    public static void union(int arr1[], int arr2[])
    {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr1.length; i++)
            set.add(arr1[i]);
        
        for(int i = 0; i < arr2.length; i++)
            set.add(arr2[i]);

        System.out.println("size: " + set.size());
        System.out.println("elements after union are: " + set);
    }
    public static void main(String args[])
    {
        int arr1[] = {7,8,9};
        int arr2[] = {6,3,8,9,1,2,4,7};
        union(arr1, arr2);

    }
}
