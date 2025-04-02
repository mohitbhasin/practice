import java.util.*;

class TopKFrequentElements {
	public static void main(String args[]) {
		int[] arr = {2,4,5,1,5,7,2,1,9,12,10,2,1,13,5,1,17,9,2,11,4};
		int k = 4;
		System.out.println(topKFrequent(arr, k));
	}

	public static List<Integer> topKFrequent(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int val: arr) {
            if(!map.containsKey(val)) {
                map.put(val, 0);
            }
            map.put(val, map.get(val)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        
        List<Integer> result = new ArrayList<>();
        
        for(int key: map.keySet()) {
            pq.offer(key);
            if(pq.size()>k) {
                pq.poll();
            }
        }
        // The result is in ascending order of frequencies. Eg: 12,15,17
        while(!pq.isEmpty()) {
            result.add(pq.poll());
        }
        return result;
    }
}