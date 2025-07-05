public class PalindromicNumberedTriangle {
    public static void main(String[] args) {
        
        /*
         *   patern:     1
         *              212
         *             32123
         *            4321234
         *           543212345
         * 
         */
        //  int oddNumber = 1;    // method - 1
        //  for(int i = 1; i <= 5; i++){
        //     for(int s = 0; s < 5-i; s++)
        //         System.out.print(" ");
        //     int number = i;
        //     for(int j = 0; j < oddNumber; j++){
        //         int mid = oddNumber/2;
        //         System.out.print(number);
        //         if(j >= mid)
        //             number++;
        //         else
        //             number--;
        //     }
        //     System.out.println();
        //     oddNumber = oddNumber + 2;
        //  } 
        int n = 5; // method - 2
        for(int i = 1; i <= n; i++)
        {
            for(int s = 0; s < n-i; s++)
                System.out.print(" ");
            
            for(int j = i; j >= 1; j--)// till 1
                System.out.print(j);
            
            for(int j = 2; j <= i; j++) // after 1
                System.out.print(j);
            
            System.out.println();
        }
        
    }   
}
