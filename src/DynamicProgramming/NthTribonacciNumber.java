class NthTribonacciNumber {
    public static void main(String args[]) {
        int n=25;
        System.out.println(tribonacci(n));
    }

    public static int tribonacci(int n) {
        int[] arr = new int[n+1];
        if(n<2) return n;
        if(n==2) return 1;
        arr[1] = 1;
        arr[2] = 1;
        
        for(int i=3; i<=n; i++) {
            arr[i]=arr[i-1] + arr[i-2] + arr[i-3];
        }
        
        return arr[n];
    }
}