import java.util.*;

class TopKFrequentElements {
	public static void main(String args[]) {
		for(int num: topKFrequent(new int[]{1,1,1,2,2,3,3,3,3}, 2)) {
			System.out.println(num);
		}
	}

	public static int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[k];
		for(int num: nums) {
			if(!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num)+1);
			}
		}

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return map.get(b)-map.get(a);
			}
		});

		for(int key: map.keySet()) {
			queue.offer(key);
		}

		for(int i=0; i<k; i++) {
			result[i]=queue.poll();
		}

		return result;
	}
}