import java.util.*;

class RemoveDuplicatesFromArray {
	public static void main(String args[]) {
		char[] chars = {'a', 'v', 'b', 'a', 'a', 'b', 'c'};
		for(char c: remove(chars)) {
			System.out.println(c+" ");
		}
	}

	public static char[] remove(char[] chars) {
		Set<Character> set = new HashSet<Character>();

		int curr=0;

		for(int i=0; i<chars.length; i++) {
			if(!set.contains(chars[i])) {
				set.add(chars[i]);
				chars[curr] = chars[i];
				curr++;
			}
		}

		return Arrays.copyOf(chars, curr);
	}
}