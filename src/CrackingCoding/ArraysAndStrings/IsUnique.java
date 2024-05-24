import java.util.Arrays;

class IsUnique {
	public static void main(String args[]) {
		System.out.println(ifUniqueChars("Mohit"));
	}

	public static boolean ifUniqueChars(String s) {
		if(s.length() > 26) return false;

		char[] chars = s.toCharArray();

		Arrays.sort(chars);
		for(int i=1; i<chars.length; i++) {
			if(chars[i]==chars[i-1]) return false;
		}

		return true;
	}
}