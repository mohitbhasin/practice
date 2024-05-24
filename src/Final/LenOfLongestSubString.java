import java.util.HashSet;
import java.util.Set;

class LenOfLongestSubString {
	public static void main(String args[]) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}

	public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int prev=0;
        int curr=0;
        int maxLen=0;
        while(curr<s.length()) {
            if(!set.contains(s.charAt(curr))) {
                set.add(s.charAt(curr++));
                maxLen=Math.max(maxLen, set.size());
            } else {                
                set.remove(s.charAt(prev++));
            }
        }
        return maxLen;
    }

}