import java.util.*;

//This is better because we are not sorting the whole array. compared to "_looksSimple.java" 

class GroupAnagramsIntuitiveButMoreLine {
	public static void main(String args[]) {
		String[] words = {"mohit","himot","bob","ithom","obb","tiomh","bbo"};
		grouping(words);
		for(String word : words) {
			System.out.print(word+" ");
		}
	}

	public static void grouping(String[] words) {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		String temp;
		ArrayList<String> list;
		for(String word: words) {
			temp=sortedString(word);
			if(!map.containsKey(temp)) {
				list = new ArrayList<>();
				list.add(word);
				map.put(temp, list);
			} else {
				list = map.get(temp);
				list.add(word);
				map.put(temp, list);
			}
		}

		int i=0;
		for(String word: map.keySet()) {
			for(String val: map.get(word)) {
				words[i++] = val;
			}
		}
	}

	private static String sortedString(String word) {
		char[] chars = word.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
}