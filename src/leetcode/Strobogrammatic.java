import java.util.*;

class Strobogrammatic {
	public static void main(String args[]) {
		System.out.println(isStrobogrammatic("1"));
	}

	public static boolean isStrobogrammatic(String s) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');
		map.put('0', '0');

		StringBuilder sb = new StringBuilder();

		for(int i=s.length()-1; i>=0; i--) {
			char c=s.charAt(i);
			if(!map.containsKey(c)) {
				return false;
			}
			sb.append(map.get(c));
		}
		return (s.equals(sb.toString()));
	}
}