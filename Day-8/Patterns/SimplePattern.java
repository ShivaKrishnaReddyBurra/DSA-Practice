class SimplePattern{

    public static void main(String[] args) {
        
        /*
         *   patern: ******
         *           ******
         *           ******
         *           ******
         * 
         */

         for(int i = 0; i < 4; i++){
            for(int j = 0; j < 6; j++){
                System.out.print("*");
            }
            System.out.println();
         }
    }
}