import java.util.*;

class RandomizeSet_Main {
	public static void main(String args[]) {
		RandomizedSet set = new RandomizedSet();
		set.insert(0);
		System.out.println("--> ");
		for(Map.Entry<Integer, Integer> entry: set.indexMap.entrySet()) {
			System.out.println(entry);

		}
		set.insert(1);
		System.out.println("--> ");
		for(Map.Entry<Integer, Integer> entry: set.indexMap.entrySet()) {
			System.out.println(entry);

		}
		set.remove(0);
		System.out.println("--> ");
		for(Map.Entry<Integer, Integer> entry: set.indexMap.entrySet()) {
			System.out.println(entry);

		}
		set.insert(2);
		System.out.println("--> ");
		for(Map.Entry<Integer, Integer> entry: set.indexMap.entrySet()) {
			System.out.println(entry);

		}
		set.remove(1);
		System.out.println("--> ");
		for(Map.Entry<Integer, Integer> entry: set.indexMap.entrySet()) {
			System.out.println(entry);

		}
		System.out.println(set.getRandom());
	}
}