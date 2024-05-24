import java.util.*;

class GroupAnagrams_withoutsort {
	public static void main(String args[]) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};

		System.out.println(groupAnagrams(strs));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
            int[] charsCount = new int[26];
            for(char c: s.toCharArray()) {
                charsCount[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int count: charsCount) {
                sb.append("#");
                sb.append(count);
            }
            String charCountString = sb.toString();
            if(!map.containsKey(charCountString)) {
                map.put(charCountString, new ArrayList<>());
            }

            map.get(charCountString).add(s);
        }

        return new ArrayList<>(map.values());
    }
}