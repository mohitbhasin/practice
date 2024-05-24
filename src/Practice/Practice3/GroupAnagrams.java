import java.util.*;

class GroupAnagrams {
	public static void main(String[] args) {
		System.out.println(group(new String[] {"eat","tea","tan","ate","nat","bat"}));
	}

	public static List<List<String>> group(String[] s) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		List<List<String>> result = new ArrayList<List<String>>();

		List<String> temp;
		for(String word: s) {
			char[] wordChars = word.toCharArray();
			Arrays.sort(wordChars);
			String sortWord = new String(wordChars);
			if(!map.containsKey(sortWord)) {
				temp = new ArrayList<String>();
				temp.add(word);
				map.put(sortWord, temp);
			} else {
				temp = map.get(sortWord);
				temp.add(word);
				map.put(sortWord, temp);
			}
		}

		for(String key : map.keySet()) {
			result.add(map.get(key));
		}

		return result;
	}
}