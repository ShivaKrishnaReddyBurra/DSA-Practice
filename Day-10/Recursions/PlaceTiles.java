public class PlaceTiles {

    public static int placeTiles(int n, int m)
    {
        // tile size is 1Xm
        if(n < m) // only horizontal placement can be done;
            return 1;
        if(n == m) // we can either place all tiles horizontal or all vertical , so only 2 ways possible
            return 2;

        int verticalPlaced = placeTiles(n-m, m);
        int horizontalPlaced = placeTiles(n-1, m);

        return verticalPlaced + horizontalPlaced;
    }
    public static void main(String[] args) {
        int n = 4, m =2;
        System.out.println(placeTiles(n, m));
    }
}
