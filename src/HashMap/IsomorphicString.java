import java.util.*;

class IsomorphicString {
	public static void main(String args[]) {
		String s = "badc";
		String t = "baba";

		System.out.println(isIsomorphic(s, t));
	}
	public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for(int i=0; i<s.length(); i++) {
            // map not having key;
                // having val in set return false
            // map having key
                // value is diff in map
        	System.out.println(set);
            if(!map.containsKey(s.charAt(i))) {
                if(set.contains(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            } else {
                if(map.get(s.charAt(i))!=t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}