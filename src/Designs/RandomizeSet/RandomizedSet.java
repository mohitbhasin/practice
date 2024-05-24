import java.util.*;

class RandomizedSet {
    Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
    List<Integer> nums = new ArrayList<>();

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if(!indexMap.containsKey(val)) {
            nums.add(val);
            indexMap.put(val, nums.size()-1);
            return true;
        }
        return false;        
    }
    
    public boolean remove(int val) {
        if(indexMap.containsKey(val)) {
            swap(val);
            removeLast();
            indexMap.remove(val);
            return true;
        }
        return false;
    }
    
    private void swap(int val) {
        int index = indexMap.get(val);
        int last = nums.size()-1;
        int temp = nums.get(index);
        nums.set(index, nums.get(last));
        nums.set(last, temp);        
    }
    
    private void removeLast() {
        nums.remove(nums.size()-1);
    }
    
    public int getRandom() {
        int rand = (int) (Math.random() * nums.size());
        return nums.get(rand);
    }
}