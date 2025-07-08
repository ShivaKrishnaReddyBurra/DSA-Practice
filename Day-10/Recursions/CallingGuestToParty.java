public class CallingGuestToParty {

    public static int callGuest(int n)
    {
        // we can call a guest either single or pair 

        if( n <= 1)
            return 1;

        int callingSingleGuest = callGuest(n-1); // remaining n-1 ways to call 
        int callingInPair = (n-1)*callGuest(n-2);

        return callingSingleGuest + callingInPair;
    }
    public static void main(String args[])
    {
        int n = 4; // guests;

        System.out.println("Total number of ways to call guests: " + callGuest(n));
    }
}
