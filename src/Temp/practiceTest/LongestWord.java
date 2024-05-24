import java.util.*;

//Not exact result. considers combination of two words only.
class LongestWord {
	public static void main(String args[]) {
		String[] words = {"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"};
		System.out.println(findLargest(words));
	}


	public static String findLargest(String[] words) {
		for(int i=0; i<words.length-1; i++) {
			String word = getStart(words[i], words);
			if(word!=null) {
				if(cheackEnd(word.substring(words[i].length()), words)) {
					return word;
				}
			}
		}
		return null;
	}

	public static String getStart(String s, String[] words) {
		for(String word: words) {
			if(!s.equals(word) && word.startsWith(s)) {
				return word;
			}
		}
		return null;
	}

	public static boolean cheackEnd(String s, String[] words) {
		for(String word: words) {
			if(!s.equals(word) && word.endsWith(s)) {
				return true;
			}
		}
		return false;
	}

}