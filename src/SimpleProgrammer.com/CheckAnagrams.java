class CheckAnagrams {
	public static void main(String args[]) {
		System.out.println(isAnagram("planetoftheapes", "ofhteepaslpaten"));
	}

	public static boolean isAnagram(String s1, String s2) {
		if(s1.length()!=s2.length()) return false;

		int[] occur = new int[26];

		for(int i=0; i<s1.length(); i++) {
			occur[s1.charAt(i) - 'a']++;
			occur[s2.charAt(i) - 'a']--;
		}

		for(int n: occur) {
			if(n!=0) return false;
		}

		return true;
	}
}