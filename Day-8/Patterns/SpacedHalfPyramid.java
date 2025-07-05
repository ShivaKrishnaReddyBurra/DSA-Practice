public class SpacedHalfPyramid {
    public static void main(String[] args) {
        
        /*
         *   patern:    *
         *             **
         *            ***
         *           ****
         * 
         */

         for(int i = 1; i <= 4; i++){
            for(int s =0 ; s < 4-i; s++)
                System.out.print(" ");
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
         }
    }    
}
