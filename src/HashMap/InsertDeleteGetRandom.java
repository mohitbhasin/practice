//Insert Delete GetRandom O(1)
import java.util.*;

class InsertDeleteGetRandom {
	public static void main(String args[]) {
		RandomizedSet obj = new RandomizedSet();

		// System.out.println(obj.insert(0));
		// System.out.println(obj.insert(1));
		// System.out.println(obj.remove(0));
		// System.out.println(obj.insert(2));
		// System.out.println(obj.remove(1));
		// System.out.println(obj.getRandom());

		System.out.println(obj.remove(0));
		System.out.println(obj.remove(0));
		System.out.println(obj.insert(0));
		System.out.println(obj.getRandom());
		System.out.println(obj.remove(0));
		System.out.println(obj.insert(0));

	}


}

class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        map.remove(val);
        int lastIndex = list.size()-1;
        list.set(index, list.get(lastIndex));
        if(map.size()>0) map.put(list.get(lastIndex), index);
        list.remove(list.size()-1);
        return true;
    }
    
    public int getRandom() {
        int index = (int) (Math.random() * 10) % list.size();
        return list.get(index);
    }
}