import java.util.*;

class Palindrome {
	public static void main(String args[]) {
		System.out.println(simpleWord("daassaad"));
		System.out.println(simpleSentence("a man a plan a canal panama"));
		System.out.println(simpleSentenceMixCase("A man a plan a canal Panama"));
	}

	public static boolean simpleWord(String s) {
		for(int i=0; i<(s.length()-1)/2; i++) {
			if(s.charAt(i)!=s.charAt(s.length()-1-i)) {
				return false;
			}
		}

		return true;
	}

	public static boolean simpleSentence(String s) {
		String[] words = s.split(" ");
		StringBuffer sb = new StringBuffer();
		for(String word: words) {
			sb.append(word);
		}
		return simpleWord(sb.toString());
	}

	public static boolean simpleSentenceMixCase(String s) {
		String[] words = s.split(" ");
		StringBuffer sb = new StringBuffer();
		for(String word: words) {
			sb.append(word);
		}
		return simpleWord(sb.toString().toLowerCase());
	}

	
}