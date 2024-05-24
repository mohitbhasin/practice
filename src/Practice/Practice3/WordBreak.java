import java.util.*;

class WordBreak {
	public static void main(String args[]) {
		List<String> dict = new ArrayList<String>();
		dict.add("apple");
		dict.add("pen");
		System.out.println(checkWord("applepenapple", 0, 1, dict));
	}

	public static boolean checkWord(String s, int start, int end, List<String> dict) {
		System.out.println(s);
		if(s.length()==0) {
			return  true;
		}
		if(end>s.length()) {
			return false;
		}
		if(dict.contains(s.substring(start, end))) {
			s=s.substring(end, s.length());
			start=0;
			end=0;
		}
		return checkWord(s, start, end+1, dict);
	}
}