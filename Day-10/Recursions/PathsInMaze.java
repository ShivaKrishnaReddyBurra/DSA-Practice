public class PathsInMaze {
    // only allowed right and doenward movements
    public static int countPaths(int i, int j, int n, int m)
    {
        if(i == n || j == m)
            return 0;
        if(i == n-1 && j == m-1 )
            return 1;

        int downwardPaths = countPaths(i+1, j, n, m);

        int rightwardPaths = countPaths(i, j+1, n, m);

        return downwardPaths + rightwardPaths;
    }
    
    public static void main(String[] args) {
        int n = 3, m =3; //matrix of 3x3 goal is reach to (2,2) from (0,0) using given moves;

        int totalPaths = countPaths(0, 0, n, m);

        System.out.println("Total Paths: " + totalPaths);
    }
}
