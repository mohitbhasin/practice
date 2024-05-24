import java.util.Map;
import java.util.HashMap;

class FirstUniqueCharacter {
	public static void main(String args[]) {
		System.out.println(getIndex("lovecodmvetleetcode"));

	}

	public static int getIndex(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for(char c: s.toCharArray()) {
			if(!map.containsKey(c)) {
				map.put(c,1);
			} else {
				int count=map.get(c);
				map.put(c, count+1);
			}
		}

		for(int i=0; i<s.length(); i++) {
			if(map.get(s.charAt(i))==1) {
				return i;
			}
		}

		return -1;
	}
}