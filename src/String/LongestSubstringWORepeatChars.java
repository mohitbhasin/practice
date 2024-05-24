import java.util.*;

// Optimized Incomplete
class LongestSubstringWORepeatChars {
	public static void main(String args[]) {
		String[] strs = {"abba"};

		for(String s: strs) {
			System.out.println(lengthOfLongestSubstring(s));
		}
	}

	public int lengthOfLongestSubstring(String s) {
        if(s.length()<2) return s.length();
        int prev = 0;
        int curr = 0;
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        while(curr<s.length()) {
            if(set.contains(s.charAt(curr))) {
                set.remove(s.charAt(prev++));
            } else {
                set.add(s.charAt(curr++));
                maxLen = Math.max(maxLen, set.size());
            }
        }
        return maxLen;
    }

	public static int lengthOfLongestSubstring_optimized(String s) {
        if(s.length()<2) return s.length();
        int curr = 0;
        int prev=0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        while(curr<s.length()) {
            if(map.containsKey(s.charAt(curr))) {
                maxLen = Math.max(maxLen, curr - prev);
                if(s.charAt(curr) > prev) prev = map.get(s.charAt(curr)) + 1;
                System.out.println("*"+map.get(s.charAt(curr)));
            }
            map.put(s.charAt(curr), curr++);
        }
        maxLen = Math.max(maxLen, curr - prev);
        System.out.println(prev);
        for(Map.Entry entry: map.entrySet()) {
        	System.out.println(entry.getKey() + ": "+ entry.getValue());
        }
        return maxLen;
    }
}