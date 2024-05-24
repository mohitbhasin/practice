import java.util.*;

class HashSetDemo {
	LinkedList<Integer> bucket;
	LinkedList[] keys;

	HashSetDemo() {
		keys = new LinkedList[17];
	}

	public static void main(String args[]) {

		HashSet hashSet = new HashSet();
		hashSet.add(4);
		hashSet.add(1);
		System.out.println(hashSet.contains(4));
		hashSet.remove(4);
		System.out.println(hashSet.contains(4));
	}

	public void add(int value) {
		int hash = hashcode(value);
		if(keys[hash]!=null) {
			bucket = keys[hash];
			bucket.addLast(value);
		} else {
			bucket = new LinkedList<Integer>();
			bucket.add(value);
			keys[hash]=bucket;
		}
	}

	public void remove(int value) {
		int hash = hashcode(value);
		bucket = keys[hash];
		if(bucket!=null) {
			bucket.remove(bucket.indexOf(value));
		}

	}

	public Boolean contains(int value) {
		int hash = hashcode(value);
		bucket = keys[hash];
		if(bucket==null) {
			return false;
		}
		for(int val: bucket) {
			if(val==value) {
				return true;
			}
		}
		return false;
	}

	private int hashcode(int key) {
		return key % keys.length;
	}
}