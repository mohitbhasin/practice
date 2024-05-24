import java.util.*;


//Not desired Result
class TrieRelated {
	public static void main(String args[]) {
		String[] words = {"cat", "banana", "dog", "nana", "walk", "walker"};
		System.out.println(searchWordCombination(words, "dognana"));
	}

	public static boolean searchWordCombination(String[] words, String s) {
		Trie trie = new Trie();
		for(String word: words) {
			trie.insert(word);
		}

		return trie.search(s);
	}


}


class Trie {
	HashMap<Character, Trie> children;
	boolean isWord;
	Trie() {
		children = new HashMap<Character, Trie>();
		isWord = false;
	}

	public void insert(String word) {
		HashMap<Character, Trie> temp = children;
		if(!temp.containsKey(word.charAt(0))) {
			for(char c: word.toCharArray()) {
				temp.put(c, new Trie());
				temp=temp.get(c).children;
			}
			isWord=true;
		} else {
			temp=temp.get(word.charAt(0)).children;
			insert(word.substring(1));
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