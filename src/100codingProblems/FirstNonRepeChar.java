import java.util.*;

class FirstNonRepeChar {
	public static void main(String args[]) {
		System.out.println(solution("abcdbacd"));
	}

	public static char solution(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c)+1);
			}
		}

		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(map.get(c)==1) return c;
		}

		return '\0';
	}
}