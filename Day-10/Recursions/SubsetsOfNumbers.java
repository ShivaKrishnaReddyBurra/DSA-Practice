import java.util.ArrayList;

public class SubsetsOfNumbers {

    public static void printSubsets(int n, ArrayList<Integer> subset)
    {
        if(n == 0) // no more numbers
        {
            for(int i = 0; i < subset.size(); i++)
            {
                System.out.print(subset.get(i) + " ");
            }
            System.out.println();
            return;
        }
        // adding number -choice 1
        subset.add(n);
        printSubsets(n-1, subset); // remaining posibilties

        // not adding number -choice 2
        subset.remove(subset.size()-1); // since we added first but don't want number to add so removing the element we added which is at last in list
        printSubsets(n-1, subset); 
    }
    public static void main(String[] args) {
        int n = 3; // first n natural numbers
        ArrayList<Integer> subset = new ArrayList<>();
        printSubsets(n, subset);

    }
}