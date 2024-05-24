import java.util.*;

class CheckAnagrams {
	public static void main(String args[]) {
		System.out.println(check("hello", "lolhe"));
	}

	public static boolean check(String s1, String s2) {
		return sort(s1).equals(sort(s2));
	}

	public static String sort(String s) {
		char[] ch = s.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
}