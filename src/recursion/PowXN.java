class PowXN {
    public static void main(String args[]) {
        double x = 2.0;
        int n = 10;
        System.out.println(myPow_binaryExponentiation(x, n));

    }

    //O(N) time. Failing for large n value;
    public static double myPow(double x, int n) {
        if(n==0) {
            return 1;
        }
        return n>0 ? x*myPow(x, n-1): 1/x*myPow(x, n+1);
    }


    //O(log N) time
    public static double myPow_binaryExponentiation(double x, int n) {
        return helper(x, (long) n);
    }

    public static double helper(double x, long n) {
        if(n==0) return 1;
        if(n<0) return 1.0/helper(x, -1*n);
        if(n%2==1) return x*helper(x*x, (n-1)/2);
        else return helper(x*x, n/2);
    }
}