class LongestPalindromicSubstring {
	public static void main(String args[]) {
		String s = "cbbd";
		
		System.out.println(getPalingrome(s));
	}

	public static String getPalingrome(String s) {
		String s_comp = new StringBuffer(s).reverse().toString();
		int i=0;
		String result = "";
		while(i<s.length()) {
			String subString = s_comp.substring(i++,s.length());
			if(s.contains(subString) && result.length()<subString.length()) {
				result = subString;
			}
		}
		return result;
	}
}