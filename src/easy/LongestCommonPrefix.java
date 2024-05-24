class LongestCommonPrefix {
	public static void main(String args[]) {
		// String[] words = {"abcdefgh", "abcefgh", "abc", "ac"};
		String[] words = {"ab", "a"};
		System.out.println(longestCommonPrefix(words));
	}


	public static String longestCommonPrefix(String[] strs) {
        if(strs.length==1) return strs[0];
        String prefix = strs[0];

        for(int i=1; i<strs.length; i++) {
            String curr = strs[i];
            int min = Math.min(curr.length(), prefix.length());
            for(int j=0; j<min; j++) {
                if(prefix.charAt(j)!=curr.charAt(j)) {
                    prefix=prefix.substring(0,j);
                    break;
                }
            }
            if(prefix.length()>curr.length()) {
                prefix=prefix.substring(0, curr.length());
            }            
        }

        return prefix;
    }
}