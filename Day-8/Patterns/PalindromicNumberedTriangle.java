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
         int oddNumber = 1;
         for(int i = 1; i <= 5; i++){
            for(int s = 0; s < 5-i; s++)
                System.out.print(" ");
            int number = i;
            for(int j = 0; j < oddNumber; j++){
                int mid = oddNumber/2;
                System.out.print(number);
                if(j >= mid)
                    number++;
                else
                    number--;
            }
            for(int s = 0; s < 5-i; s++)
                System.out.print(" ");
            System.out.println();
            oddNumber = oddNumber + 2;
         }  
    }    
}
