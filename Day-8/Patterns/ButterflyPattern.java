public class ButterflyPattern {
    public static void main(String[] args) {
        
        /*
         *   patern: *      *
         *           **    **
         *           ***  ***
         *           ********
         *           ********
         *           ***  ***
         *           **    **
         *           *      *
         */
         int n = 4;
         for(int i = 1; i <= n; i++){ // first n rows
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }

            for(int s =0 ; s < 2*(n-i); s++)
                System.out.print(" ");
        
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
         }

         for(int i = n; i > 0; i--){ // reverse the first n rows
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }

            for(int s =0 ; s < 2*(n-i); s++)
                System.out.print(" ");

            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
         }
    } 
}
