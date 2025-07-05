public class DiamondPattern {
    public static void main(String[] args) {
        /*
         *   patern:    *
         *             ***
         *            *****
         *           *******
         *           *******
         *            *****
         *             ***
         *              *
         * 
         */

         int n = 4;
         
         for(int i = 1 ; i <= n; i++) // upper half
         {
            for(int s = 0; s < n-i; s++)
                System.out.print(" ");
            
            for(int j = 0; j < 2*i-1 ; j++)
                System.out.print("*");
            
            System.out.println();
         }

         for(int i = n ; i > 0; i--) // lower half
         {
            for(int s = 0; s < n-i; s++)
                System.out.print(" ");
            
            for(int j = 0; j < 2*i-1 ; j++)
                System.out.print("*");
            
            System.out.println();
         }
    }    
}
