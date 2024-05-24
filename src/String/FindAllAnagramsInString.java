import java.util.*;

class FindAllAnagramsInString {
	public static void main(String args[]) {
		// String s = "cbaebabacd", p = "abc";
		// String s = "abab", p = "ab";
		String s = "aaaaaaaaaa", p = "aaaaaaaaaaaaa";
		System.out.println(findAnagrams(s, p));
	}

	public static List<Integer> findAnagrams(String s, String p) {
        if(s.length()<p.length()) return new ArrayList<>();
        int[] p_chars = new int[26];
        int[] s_chars = new int[26];
        for(int i=0; i<p.length(); i++) {
            p_chars[p.charAt(i) - 'a']++;
            s_chars[s.charAt(i) - 'a']++;
        }

        List<Integer> result = new ArrayList<>();

        
        int start=0;
        int end=p.length();

        while(end<=s.length()) {
            if(Arrays.equals(s_chars, p_chars)) {
                result.add(start);
            }
            if(end<s.length()) {
                s_chars[s.charAt(start++) - 'a']--;
                s_chars[s.charAt(end) - 'a']++;
            }
            end++;
        }

        return result;
    }
}
