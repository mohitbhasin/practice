class LongestPalindromicSubString {
	public static void main(String args[]) {
		String s = "fabebaq";
		System.out.println(getLongest(s));
	}

	public static String getLongest(String s) {
		String longest=s.substring(0,1);
		for(int i=0; i<s.length(); i++) {
			// two if conditions to check cases of odd and even - beb & bb
			String temp = expandAround(s,i,i);
			if(temp.length() > longest.length()) {
				longest=temp;
			}
			temp = expandAround(s,i,i+1);
			if(temp.length() > longest.length()) {
				longest=temp;
			}
		}
		return longest;
	}

	// fabebaq
	public static String expandAround(String s, int left, int right) {
		while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left+1, right);
		// for eg. s = abeba; left & right = 2, after l & r = 0 & 4, next it will be -1 & 5 so length is 5 - (-1) - 1 = 5
	}
}