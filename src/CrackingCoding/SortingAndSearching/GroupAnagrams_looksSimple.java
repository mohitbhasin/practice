import java.util.*;

//having class with comparator and using in Array for sort, sorts the whole arry. ref - book 10.2
class GroupAnagrams_looksSimple {
	public static void main(String args[]) {
		String[] words = {"mohit","himot","bob","ithom", "help", "obb", "pelh", "tiomh", "bbo", "eplh"};
		Arrays.sort(words, new GroupAnagramsComparator());
		for(String word : words) {
			System.out.print(word+" ");
		}
	}
}

class GroupAnagramsComparator implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		return sortChars(s1).compareTo(sortChars(s2));
	}

	private String sortChars(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
}