import java.util.*;

class GroupAnagrams {
	public static void main(String args[]) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(grouping(strs));
	}

	public static List<List<String>> grouping(String[] words) {
		Map<String, List<String>> anagramMap = new HashMap<>();
		List<List<String>> result = new ArrayList<>();
		List<String> anagramList;
		for(String word: words) {
			String sorted = sort(word);
			if(!anagramMap.containsKey(sorted)) {
				anagramList = new ArrayList<>();
				anagramList.add(word);
				anagramMap.put(sorted, anagramList);
			} else {
				anagramList = anagramMap.get(sorted);
				anagramList.add(word);
				anagramMap.put(sorted, anagramList);
			}
		}

		for(String key: anagramMap.keySet()) {
			result.add(anagramMap.get(key));
		}

		return result;

	}

	public static String sort(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
}