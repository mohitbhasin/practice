import java.util.*;

class WordsToNumbers {
	public static void main(String args[]) {
		System.out.println(computeNumber(new String[]{"one", "five","one", "five","one","one","one","one","one"}));
	}

	public static int computeNumber(String[] words) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);
		map.put("five", 5);
		map.put("six", 6);
		map.put("seven", 7);
		map.put("eight", 8);
		map.put("nine", 9);
		map.put("null", 0);

		Set<String> numSet = new HashSet<>();
		for(String s: words) {
			numSet.add(s);
		}

		int result = 0;
		int i=0;
		while(!numSet.isEmpty() || i<) {
			result+=map.get(words[i]);
			result*=10;
			numSet.remove(words[i++]);
		}
		result/=10;
		return result;
	}
}