class ClimbingStairs {
	public static void main(String args[]) {
		System.out.println(climbStairs_approach1(45));
		System.out.println(climbStairs_approach2(45));
		System.out.println(climbStairs_approach3(45));
	}

	static int[] memo;

	public static int climbStairs_approach1(int n) {
		memo = new int[n+1];
		return dp(n);
	}

	public static int dp(int n) {
		if(n<=2) return n;
		if(memo[n]>0) return memo[n];
		memo[n] = dp(n-1) + dp(n-2);
		return memo[n];
	}

	public static int climbStairs_approach2(int n) {
		int[] dp = new int[n+1];
		dp[1]=1;
		dp[2]=2;
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}


	public static int climbStairs_approach3(int n) {
        int a=1;
        int b=2;
        int sum=1;
        for(int i=3; i<=n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}