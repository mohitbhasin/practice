import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class Prctice11 {
	public static void main(String args[]) {
		System.out.println(removeVovels("aeiou"));
		System.out.println(jewelsStones("aA", "aAAbbbb"));
		System.out.println(longestWithoutRepeatingChars("pwwkew"));
		System.out.println(longestWithoutRepeatingChars2("abcabcbb"));
		System.out.println(validParenthesis("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
	}

	public static String removeVovels(String s) {
		Set<Character> vowels = new HashSet<Character>();
		vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u'); 
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<s.length(); i++) {
			if(!vowels.contains(s.charAt(i))) {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	public static int jewelsStones(String j, String s) {
		int count=0;
		Set<Character> jewels = new HashSet<Character>();
		for(char c : j.toCharArray()) jewels.add(c);

		for(int i=0; i<s.length(); i++) {
			if(jewels.contains(s.charAt(i))) count++; 
		}
		return count;
	}

	public static int longestWithoutRepeatingChars(String s) {
		int maxLen=0;
		List<Character> uniqCharsList = new ArrayList<Character>();
		for(int i=0; i<s.length(); i++) {
			char temp = s.charAt(i);
			if(!uniqCharsList.contains(temp)) {
				uniqCharsList.add(temp);
			} else {
				while(uniqCharsList.contains(temp)) {
					uniqCharsList.remove(0);
				}
				uniqCharsList.add(temp);
			}
			maxLen=Math.max(maxLen, uniqCharsList.size());
		}
		return maxLen;
	}

	public static int longestWithoutRepeatingChars2(String s) {
		Set<Character> uniqChars = new HashSet<Character>();
		int beg=0;
		int end=0;
		int maxLength=0;
		while(end<s.length()) {
			char temp=s.charAt(end);
			if(!uniqChars.contains(temp)) {
				uniqChars.add(temp);
				end++;
			} else {
				uniqChars.remove(s.charAt(beg++));
			}
			maxLength=Math.max(maxLength, uniqChars.size());
		}
		return maxLength;
	}

	public static boolean validParenthesis(String s) {
		Stack<Character> openPar = new Stack<Character>();
		int asteric = 0;
		for(char c: s.toCharArray()) {
			if(c==')') {
				if(openPar.size()==0 && asteric==0) return false;
				if(openPar.size()!=0) openPar.pop();
				else asteric--;
			} 
			else if(c=='*') asteric++;
			else openPar.push('(');
		}
		return openPar.size()<=asteric;
	}
}
























