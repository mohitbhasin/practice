import java.util.*;

class RemoveDplicates {
	public static void main(String args[]) {
		System.out.println(removeDup("abcbadefgffhai"));
	}

	public static String removeDup(String s) {
		char[] chars = s.toCharArray();
		Set<Character> set = new HashSet<>();
		int curr=0;
		for(int i=0; i<chars.length; i++) {
			if(!set.contains(chars[i])) {
				set.add(chars[i]);
				char temp = chars[i];
				chars[i] = chars[curr];
				chars[curr++] = temp;
			}
		}

		return new String(Arrays.copyOf(chars, curr));
	}
}