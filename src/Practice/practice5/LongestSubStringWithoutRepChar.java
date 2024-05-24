import java.util.*;

class LongestSubStringWithoutRepChar {
	public static void main(String[] args) {
		// System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

	public static int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		int maxLen = Integer.MIN_VALUE;
		int prev = 0;
		int curr = 0;
		while(curr<s.length()) {
			if(!set.contains(s.charAt(curr))) {
				set.add(s.charAt(curr++));
			} else {
				if(maxLen<set.size()) {
					maxLen=set.size();
				}
				set.remove(s.charAt(prev++));
			}
		}
		return maxLen;
	}
}