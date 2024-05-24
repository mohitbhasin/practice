class LongestCommonPrefix {
	public static void main(String args[]) {
		String[] strs = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(strs));
	}

	public static String longestCommonPrefix(String[] strs) {
        if(strs.length==1) return strs[0];
        String prefix = strs[0];

        for(int i=1; i<strs.length; i++) {
            String curr = strs[i];
            int index = 0;
            while(index<prefix.length() && index<curr.length()) {
                if(prefix.charAt(index)!=curr.charAt(index)) {
                    break;
                }
                index++;
            }
            if(index==0) return "";
            prefix = prefix.substring(0, index);
        }
        return prefix;
    }
}