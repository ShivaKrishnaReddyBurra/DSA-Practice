class Sol{

    static int fib(int n)
    {
        if(n == 0)
            return 0;
        else if( n == 1)
            return 1;
        else
            return fib(n-1)+fib(n-2);
    }
    public static void main(String args[]){
        //Just printing first 20 numbers of fib
        int num1 = 0;
        int num2 = 1;
        System.out.print(num1+" "+num2+ " ");
        for(int i = 0; i < 18; i++ ){
            int nextNum = num1 + num2;
            System.out.print(nextNum+" ");
            num1 = num2;
            num2 = nextNum;
        }
        // print numbers using recusion
        System.out.println();
        for(int i = 0; i <20; i++ ){
            System.out.print(fib(i)+ " ");
        }
    } 
}