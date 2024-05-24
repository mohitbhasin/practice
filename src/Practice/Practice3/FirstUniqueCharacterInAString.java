class FirstUniqueCharacterInAString {
	public static void main(String args[]) {
		System.out.println(getUniqueChar("leetcode"));
		System.out.println(getUniqueChar("loveleetcode"));
		System.out.println(getUniqueChar("aabb"));
	}

	public static int getUniqueChar(String s) {
		int[] charCount = new int[26];
		int index=0;
		for(char c: s.toCharArray()) {
			if(c>='a' && c<='z') {
				index = c - 'a';
			}
			if(c>='A' && c<='Z') {
				index = c = 'A';
			}
			charCount[index]++;
		}

		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c>='a' && c<='z') {
				index = c - 'a';
			}
			if(c>='A' && c<='Z') {
				index = c = 'A';
			}
			if(charCount[index]==1) {
				return i;
			}
		}

		return -1;

	}
}
