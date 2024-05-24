import java.util.*;

class MinCostClimbingStairs {
	public static void main(String args[]) {
		// int[] cost = {10,15,20};
		int[] cost = {1,100,1,1,1,100,1,1,100,1};
		System.out.println(minCostClimbingStairs(cost));
	}

    // two variables
    public int minCostClimbingStairs(int[] cost) {
        int one_prev = 0;
        int two_prev = 0;

        for(int c: cost) {
            int temp = Math.min(one_prev, two_prev) + c;
            two_prev = one_prev;
            one_prev = temp;
        }

        return Math.min(one_prev, two_prev);
    }
    
    // memo array
	public static int minCostClimbingStairs(int[] cost) {
        if(cost.length==1) return cost[0];
        int[] memo = new int[cost.length];
        
        memo[0]=cost[0];
        memo[1]=cost[1];
        
        for(int i=2; i<cost.length; i++) {
            memo[i]=cost[i] + Math.min(memo[i-1], memo[i-2]);
        }
        return Math.min(memo[cost.length-1], memo[cost.length-2]);
    }
}