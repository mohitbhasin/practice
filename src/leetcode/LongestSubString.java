import java.util.*;

class LongestSubString {
	public static void main(String args[]) {
		String s = "";
		System.out.println(longest(s));
	}

	public static int longest(String s) {
		if(s.length()==0) {
			return 0;
		}
		int start=0;
		int end=0;
		Set<Character> set = new HashSet<Character>();
		int count=Integer.MIN_VALUE;
		while(end<s.length()) {
			if(!set.contains(s.charAt(end))) {
				set.add(s.charAt(end++));
				count=Math.max(set.size(), count);
			} else {
				set.remove(s.charAt(start++));
			}
		}
		return count;
	}
}