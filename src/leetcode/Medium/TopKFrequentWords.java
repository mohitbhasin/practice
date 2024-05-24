import java.util.*;

class TopKFrequentWords {
	public static void main(String args[]) {
		String[] words = {"i","love","leetcode","i","love","coding"};
		int k = 2;
		System.out.println(topKFrequent(words, k));
	}

	public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Queue<String> pq = new PriorityQueue<>((a, b) -> {
        	int diff = map.get(a) - map.get(b);
        	if(diff==0) {
        		return a.compareTo(b);
        	} else {
        		return diff;
        	}
        });
        for(String key: map.keySet()) {
            pq.offer(key);
            if(pq.size()>k)
            pq.poll();
        }

        ArrayList<String> result = new ArrayList<>();
        while(!pq.isEmpty()) {
            result.add(0, pq.poll());
        }
        return result;
    }
}