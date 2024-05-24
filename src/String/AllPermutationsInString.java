import java.util.*;

class AllPermutationsInString {
	public static void main(String args[]) {
		// String s = "cbaebabacd";
		// String p = "abc";

		String s = "abab";
		String p = "ab";

		System.out.println(findAnagrams(s, p));
	}

	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length()>s.length()) return result;
        Map<Character, Integer> p_map = new HashMap<>();
        Map<Character, Integer> s_map = new HashMap<>();
        for(int i=0; i<p.length(); i++) {
            char c1 = p.charAt(i);
            char c2 = s.charAt(i);
            if(!p_map.containsKey(c1)) {
                p_map.put(c1, 1);
            } else {
                p_map.put(c1, p_map.get(c1)+1);
            }
            if(!s_map.containsKey(c2)) {
                s_map.put(c2, 1);
            } else {
                s_map.put(c2, s_map.get(c2)+1);
            }
        }
        int left = 0;
        int right = p.length();


        while(right<=s.length()) {
            if(p_map.equals(s_map)) {
                result.add(left);
            }

            if(right<s.length()) {
            	char temp = s.charAt(left++);
	            int count = s_map.get(temp);
	            if(count==1) {
	                s_map.remove(temp);
	            } else {
	                s_map.put(temp, count-1);
	            }

	            // adding right window charater
	            temp = s.charAt(right);
	            if(!s_map.containsKey(temp)) {
	                s_map.put(temp, 1);
	            } else {
	                s_map.put(temp, s_map.get(temp)+1);
	            }
            }
            right++;
        }

        return result;
    }
}