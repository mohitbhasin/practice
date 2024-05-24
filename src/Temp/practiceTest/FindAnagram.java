class FindAnagram {
	public static void main(String args[]) {
		String s = "cbaebabacd";
        String p = "abc";


	}

	public static List<Integer> findAnagram(String s, String p) {
		Map<Character, Integer> pCount = new HashMap<Character, Integer>();
		Map<Character, Integer> sCount = new HashMap<Character, Integer>();
		for(char c: p.toCharArray()) {
			if(pCount.containsKey(c)) {
				pCount.put(c, pCount.get(c)+1);
			} else {
				pCount.put(c,1);
			}
		}

		for(int i=0; i<s.length(); i++) {
			if(!sCount.containsKey(s.charAt(i))) {
				sCount.put(s.toCharArray(i), 1);
			} else {
				sCount.put(s.charAt(i), sCount.get(s.charAt(i),+1));
			}
			
		}
	}
}