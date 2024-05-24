import java.util.*;

class RemoveDuplicates {
	public static void main(String args[]) {
		String s = "sjdhfnasjhjfdesa"; sjdhfnae
		System.out.println(remove(s));
	}

	public static String remove(String s) {
		Set<Character> set = new HashSet<Character>();
		char[] chars = s.toCharArray();
		int index=0;
		for(int i=0; i<chars.length; i++) {
			chars[index]=chars[i];
			if(!set.contains(chars[i])) {
				set.add(chars[i]);
				index++;
			}
		}

		return new String(chars, 0, index);
	}
}