import java.util.HashSet;

class DuplicateCharacters {
	public static void main(String args[]) {
		printDuplicate("abcdefghijaklmgcpqre");
	}

	public static void printDuplicate(String s) {
		HashSet<Character> set = new HashSet<Character>();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(!set.contains(c)) {
				set.add(c);
			}
			else {
				System.out.println(c);
			}
		}
	}
}