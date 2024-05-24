import java.util.*;

class FruitIntoBaskets {
	public static void main(String args[]) {
		int[] nums = {1,2,1};
		System.out.println(totalFruit(nums));
	}

	public static int totalFruit(int[] fruits) {
        int prev=0;
        int curr=0;
        int max=0;
        Map<Integer, Integer> map = new HashMap<>();
        
        while(curr<fruits.length) {
        	int fruit = fruits[curr];
            if(!map.containsKey(fruit) && map.size()==2) {
            	int prevFruit = fruits[prev++];
                int count = map.get(prevFruit);
                if(count==1) map.remove(prevFruit);
                else map.put(prevFruit, count-1);
            } else {
                map.put(fruit, map.getOrDefault(fruit, 0)+1);
                max=Math.max(max, curr-prev+1);
                curr++;
            }
        }
        return max;
    }
}