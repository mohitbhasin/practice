package leetcode.all;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
	public static void main(String args[]) {
		
		
		boolean[] bool = new boolean[5];
//		for(int i = 0; i< 5; i++) {
//			System.out.println(bool[i]);	
//		}
//		String s = "pwwkewaabcf";
		String s = "abcabcb";
		System.out.println("Final result = "+lengthOfLongestSubstring2(s));
		
	}
	//not efficient O(n2)
	public static int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int i = 0, j = 0;
        int maxLen = 0;
        boolean[] exists = new boolean[256];
        while(j < n){
            if(exists[s.charAt(j)]){
                // met the repeat character, update the maxlen;
                maxLen = Math.max(maxLen, j - i);
                // update pointer i
                while(s.charAt(i) != s.charAt(j)){
                    exists[s.charAt(i)] = false;
                    i++;
                }
                i++;
                j++;
            } else {
                exists[s.charAt(j)] = true;
                j++;
            }
        }
        maxLen = Math.max(maxLen, n - i);
        return maxLen; 
    }
    
	//Efficient O(n). this is Sliding window concept.
    public static int lengthOfLongestSubstring2(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<Character>();
    
        while (j < s.length()) {
        	System.out.println("set="+set+" i="+i+" j="+j+" max="+max);
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
    
        return max;
    }
    
    public int lengthOfLongestSubstring3(String s) {
        boolean[] exist = new boolean[256];
        int i = 0, maxLen = 0;
        for(int j = 0; j < s.length(); j++) {
            while(exist[s.charAt(j)]) {
                exist[s.charAt(i)] = false;
                i++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}
