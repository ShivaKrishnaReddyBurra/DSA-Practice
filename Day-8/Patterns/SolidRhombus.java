public class SolidRhombus {
    public static void main(String[] args) {
        
        /*
         *   patern:      *****
         *               *****
         *              *****
         *             *****
         *            *****
         * 
         */

         for(int i = 0; i < 5; i++){
            for(int s = 0; s < 5 - i; s++) // for spaces 
                System.out.print(" ");
            for(int j = 0; j < 5; j++){
                System.out.print("*");
            }
            System.out.println();
         }
    }
}
