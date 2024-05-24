import java.util.*;

class FindTopKWords {
	public static void main(String args[]) {
		System.out.println(findWords("three three one two three two three two one three three", 3));
	}

	public static ArrayList<String> findWords(String s, int k) {
		ArrayList<String> result = new ArrayList<String>();
		HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
		PriorityQueue<String> queue = new PriorityQueue<String>(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return frequencies.get(s2)-frequencies.get(s1);
			}
		});
		String[] words = s.split(" ");

		for(String word: words) {
			if(!frequencies.containsKey(word)) {
				frequencies.put(word, 1);
			} else {
				frequencies.put(word, frequencies.get(word)+1);
			}
		}

		for(String word: frequencies.keySet()) {
			queue.add(word);
		}

		for(int i=0; i<k; i++) {
			result.add(queue.poll());
		}
		return result;
	}
}