import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class ConstantInsertRemoveRandom {
	Map<Integer, Integer> map = new HashMap<>();
	List<Integer> list = new ArrayList<>();
	// Random rand = new Random();

	public void insert(int val) {
		if(!map.containsKey(val)) {
			map.put(val, list.size());
			list.add(val);
		}
	}

	public void remove(int val) {
		if(map.containsKey(val)) {
			int index = map.get(val);
			list.set(index, list.get(list.size()-1));
			list.remove(list.size()-1);
			map.remove(val);
		}
	}

	public int getRandom() {
		if(list.isEmpty()) return -1;
		// better performance
		return list.get(ThreadLocalRandom.current().nextInt(list.size()));
		// return list.get(rand.nextInt(list.size()));
	}
}