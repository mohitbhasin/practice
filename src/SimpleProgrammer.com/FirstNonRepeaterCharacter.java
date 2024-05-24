import java.util.HashMap;

class FirstNonRepeaterCharacter {
	public static void main(String args[]) {
		System.out.println(getFirstUnique("altoidsolta"));
	}

	public static char getFirstUnique(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(!map.containsKey(s.charAt(i))) {
				map.put(c, 1);
			}
			else {
				map.put(c, map.get(c)+1);
			}
		}

		for(int i=0; i<s.length(); i++) {
			if(map.get(s.charAt(i))==1) return s.charAt(i);
		}

		return '\0';
	}
}