import java.util.*;
class LongestSubStringWithoutRepChar {
	public static void main(String args[]) {
		System.out.println(longestSubString("pwwkew"));
	}
	public static int longestSubString(String s) {
		int start = 0;
		int end = 0;
		int maxLength = 0;
		HashSet<Character> set = new HashSet<Character>();
		while(end<s.length()) {
			if(!set.contains(s.charAt(end))) {
				set.add(s.charAt(end++));
				maxLength = Math.max(maxLength, end - start);
			} else {
				set.remove(s.charAt(start++));
			}
		}
		return maxLength;
	}
}
