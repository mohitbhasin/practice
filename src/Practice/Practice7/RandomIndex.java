import java.util.*;

class RandomIndex {
    public static void main(String args[]) {
        int[] nums = {
            1773,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
        };

        RandomIndex obj = new RandomIndex();
        obj.Solution(nums);
        for(int i=0; i<10000; i++) {
            System.out.println(obj.pick(1));
        }
    }


    Map<Integer, List<Integer>> indexMap;
    Random rand;
    public void Solution(int[] nums) {
        rand = new Random();
        indexMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(!indexMap.containsKey(nums[i])) {
                indexMap.put(nums[i], new ArrayList());
            }
            indexMap.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
         List<Integer> indexes = indexMap.get(target);
        return indexes.get(rand.nextInt(indexes.size()));
    }
}