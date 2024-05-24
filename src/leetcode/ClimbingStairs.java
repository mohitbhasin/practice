import java.util.*;

class ClimbingStairs {
	public static void main(String args[]) {
		System.out.println(climbStairs(44, new HashMap<Integer, Integer>()));
	}

	// public int climbStairs(int n) {
 //        return helper(n);
 //    }
    
    public static int climbStairs(int steps, Map<Integer, Integer> map) {
        if(steps==0) {        	
            return 1;
        }
        
        if(steps<0) {
            return 0;
        }
        if(map.containsKey(steps)) {
        	return map.get(steps);
        }
        map.put(steps, climbStairs(steps - 1, map) + climbStairs(steps - 2, map));
        return map.get(steps);
    }
}