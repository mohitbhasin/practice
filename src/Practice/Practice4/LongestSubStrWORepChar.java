import java.util.*;
class LongestSubStrWORepChar {
	public static void main(String args[]) {
		System.out.println(longestSubStr("abcadb"));
		System.out.println(longestSubStr2("abcadb"));
	}

	//based on end and start diff
	public static int longestSubStr(String s) {
		if(s.length()<1) {
			return s.length();
		}
		int start=0;
		int end=0;
		Set<Character> set = new HashSet<Character>();
		int count=1;
		while(end<s.length()) {
			if(!set.contains(s.charAt(end))) {
				set.add(s.charAt(end++));
				count=Math.max(count, (end-start));
			} else {
				set.remove(s.charAt(start++));
			}
		}
		return count;
	}
	//based on set length
	public static int longestSubStr2(String s) {
		if(s.length()<1) {
			return s.length();
		}
		int start=0;
		int end=0;
		int maxLen=0;
		Set<Character> set = new HashSet<Character>();
		while(end<s.length()) {
			if(!set.contains(s.charAt(end))) {
				set.add(s.charAt(end++));
			} else {
				set.remove(s.charAt(start++));
			}
			maxLen=Math.max(maxLen, set.size());
		}
		return maxLen;
	}
}