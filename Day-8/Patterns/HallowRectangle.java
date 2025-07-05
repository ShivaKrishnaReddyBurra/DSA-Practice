public class HallowRectangle {
    public static void main(String[] args) {
        
        /*
         *   patern: ******
         *           *    *
         *           *    *
         *           ******
         * 
         */

         for(int i = 0; i < 4; i++){
            for(int j = 0; j < 6; j++){
                if(i == 0 || j == 0 || i == 3 || j == 5)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
         }
    }
}
