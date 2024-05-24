class LongestCommonPrefix {
	public static void main(String args[]) {
		// String[] words = {"abcdefgh", "abcefgh", "abc", "ac"};
		// String[] words = {"ab", "a"};
		System.out.println(findPrefix(words));
		System.out.println(longestCommonPrefix(words));
	}


	public static String longestCommonPrefix(String[] strs) {
        if(strs.length==1) return strs[0];
        String prefix = strs[0];

        for(int i=1; i<strs.length; i++) {
            String curr = strs[i];
            for(int j=0; j<Math.min(curr.length(), prefix.length()); j++) {
                if(prefix.charAt(j)!=curr.charAt(j)) {
                    prefix=prefix.substring(0,j);
                }
            }
            prefix=prefix.substring(0,Math.min(curr.length(), prefix.length()));
        }

        return prefix;
    }
}