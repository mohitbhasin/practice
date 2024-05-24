class FirstNonRepChar {
	public static void main(String args[]) {
		System.out.println(getNonRepChar("abcabcdabc"));
	}

	public static char getNonRepChar(String s) {
		int[] alphaCount = new int[26];

		for(char c: s.toCharArray()) {
			alphaCount[c - 'a'] += 1;
		}

		for(int i=0; i<26; i++) {
			if(alphaCount[i]==1) {
				return (char) ('a' + i);
			}
		}
		return '1';
	}
}