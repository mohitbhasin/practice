import java.util.*;

class DeleteAndEarn {
	public static void main(String args[]) {
		int[] nums = {2,2,3,3,3,4};
		// int[] nums = {8,10,4,9,1,3,5,9,4,10};
		System.out.println(deleteAndEarn(nums));
	}

	public static int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> points = new HashMap<>();
        int max_val=0;
        for(int num: nums) {
            if(!points.containsKey(num)) {
                points.put(num, 0);
            }
            points.put(num, points.get(num)+num);
            max_val = Math.max(max_val, num);
        }
        
        Map<Integer, Integer> cache = new HashMap<>();
        
        cache.put(0,0);
        cache.put(1,points.getOrDefault(1,0));
        for(int i=2; i<=max_val; i++) {
            int x = points.getOrDefault(i, 0);
            int curr=Math.max(cache.get(i-1), cache.get(i-2)+x);
            cache.put(i, curr);
        }
        
        return cache.get(max_val);
    }
}