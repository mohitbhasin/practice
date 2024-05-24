class CheckPermutation {
	public static void main(String args[]) {
		System.out.println(isPermutable("Mohit", "oiMth"));
	}

	public static boolean isPermutable(String s1, String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}

		int[] map = new int[26];

		for(int i=0; i<s1.length(); i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			if(c1 >= 'a' && c1<='z') {
				map[c1 - 'a']++;
			}
			if(c1 >= 'A' && c1<='Z') {
				map[c1 - 'A']++;
			}
			if(c2 >= 'a' && c2<='z') {
				map[c2 - 'a']--;
			}
			if(c2 >= 'A' && c2<='Z') {
				map[c2 - 'A']--;
			}
		}

		for(int val: map) {
			if(val!=0) {
				return false;
			}
		}

		return true;
	}
}