public class TowerOfHanoi {
    public static void towerOfHanoi(int n, String src, String helper, String dst)
    {
        if(n == 1)
        {
            System.out.println("move disk- " +n+" from "+ src +" to "+ dst);
            return;
        }

        towerOfHanoi(n-1, src, dst, helper);
        System.out.println("move disk- " +n+" from "+ src +" to "+ dst);
        towerOfHanoi(n-1, helper, src, dst);
    }
    public static void main(String[] args) {
        int n = 4;

        towerOfHanoi(n, "S", "H", "D");
    }
}
