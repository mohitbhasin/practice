import java.util.*;

class LongestSubStringWithoutRepeatingChars {
	public static void main(String args[]) {
		System.out.println(solution("abcbaecbb"));
	}

	public static int solution(String s) {
		Set<Character> set = new HashSet<>();

		int prev = 0;
		int curr = 0;
		int maxLen = Integer.MIN_VALUE;
		while(curr<s.length()) {
			if(!set.contains(s.charAt(curr))) {
				set.add(s.charAt(curr++));
			} else {
				maxLen=Math.max(maxLen, set.size());
				set.remove(s.charAt(prev++));
			}
		}
		return maxLen;
	}
}