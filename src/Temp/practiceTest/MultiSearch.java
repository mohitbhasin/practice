import java.util.*;

class MultiSearch {
	public static void main(String args[]) {
		String[] words = {"is", "ppi", "hi", "sis", "i", "ssippi"};
		System.out.println(search("mississippi", words));

		//----------------- Trie one is incorrect.
		String missi = "mississippi";
		Trie t = new Trie();
		for(int i=0; i<missi.length(); i++) {
			t.insert(missi.substring(i));
		}

		List<String> result = new ArrayList<String>();
		for(String word: words) {
			if(t.search(word)) {
				result.add(word);
			}
		}
		System.out.println(result);

	}

	public static List<String> search(String s, String[] t) {
		List<String> result = new ArrayList<String>();
		char[] chars = s.toCharArray();
		for(String word: t) {
			int index=0;
			for(char c: chars) {
				if(index<word.length() && word.charAt(index)==c) {
					index++;
				}
			}
			if(index==word.length()) {
				result.add(word);
			}
		}
		return result;
	}
}

class Trie {
	HashMap<Character, Trie> children;
	Trie() {
		children = new HashMap<Character, Trie>();
	}

	public void insert(String word) {
		HashMap<Character, Trie> temp = children;
		if(!temp.containsKey(word.charAt(0))) {
			for(char c: word.toCharArray()) {
				temp.put(c, new Trie());
			}
		}
	}

	public boolean search(String word) {
		HashMap<Character, Trie> temp = children;

		for(int i=0; i<word.length(); i++) {
			if(!temp.containsKey(word.charAt(i))) {
				return false;
			}
			temp = temp.get(word.charAt(i)).children;
		}
		return true;
	}
}