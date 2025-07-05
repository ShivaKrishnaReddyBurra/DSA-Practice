public class NumberPyramid {
    public static void main(String[] args) {
        
        /*
         *   patern:     1    
         *              2 2   
         *             3 3 3  
         *            4 4 4 4
         *           5 5 5 5 5 
         * 
         */

         for(int i = 1; i <= 5; i++){
            for(int s = 0; s < 5-i; s++)
                System.out.print(" ");
            for(int j = 0; j < i; j++){
                System.out.print(i+ " ");
            }
            System.out.println();
         }  
    }    
}
