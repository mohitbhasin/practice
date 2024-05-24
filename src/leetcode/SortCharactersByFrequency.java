import java.util.*;

class SortCharactersByFrequency {
	public static void main(String args[]) {
		System.out.println(frequencySort("eert"));
	}

	public static String frequencySort(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		List<Character> chars = new ArrayList<Character>();
		for(char c: s.toCharArray()) {
			chars.add(c);
			if(!map.containsKey(c)) {
				map.put(c, 1);
			}
			else {
				map.put(c, map.get(c)+1);
			}
		}

		chars.sort(new Comparator<Character>() {
			public int compare(Character c1, Character c2) {
				if(map.get(c1)>map.get(c2)) {
					return -1;
				}
				else if(map.get(c1)<map.get(c2)) {
					return 1;
				}
				else {
					return 0;
				}
			}
		});

		StringBuilder sb = new StringBuilder();
		for(char c: chars) {
			sb.append(c);
		}
		return sb.toString();
	} 
}