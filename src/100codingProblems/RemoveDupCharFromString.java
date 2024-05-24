import java.util.*;

class RemoveDupCharFromString {
	public static void main(String args[]) {
		System.out.print(removeDup("fcbabfd"));
	}

	public static String removeDup(String s) {
		char[] chars = s.toCharArray();
		Set<Character> set = new HashSet<Character>();
		int j=0;
		for(int i=0;i<chars.length; i++) {
			if(!set.contains(chars[i])) {
				set.add(chars[i]);
				char temp = chars[i];
				chars[i] = chars[j];
				chars[j] = temp;
				j++;
			}
		}

		return new String(Arrays.copyOf(chars, j));
	}
}