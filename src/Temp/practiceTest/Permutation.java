import java.util.*;

class Permutation {
	static List<String> result;
	static char[] chars;
	public static void main(String args[]) {
		String s = "abc";
		result = new ArrayList<>();
		chars = s.toCharArray();
		generate(0);
		System.out.println(result);
	}

	public static void generate(int first) {
		if(first == chars.length) {
			result.add(new String(chars));
			return;
		}

		for(int i=first; i<chars.length; i++) {
			swap(first, i);
			generate(first+1);
			swap(first, i);
		}
	}

	public static void swap(int i, int j) {
		char c = chars[i];
		chars[i] = chars[j];
		chars[j] = c;
	}
}