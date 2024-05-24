class LongestPalindromicSubstring {
	public static void main(String args[]) {
		String s = "cbbd";
		System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome_constantSpace(s));
	}

    // this takes o(n) space as every time palingrome is found, substring is created
	public static String longestPalindrome(String s) {
        String result = s.substring(0,1);
        for(int i=0; i<s.length(); i++) {
            int len1 = expandPalindrome(s, i, i);
            int len2 = expandPalindrome(s, i, i+1);
            int len = Math.max(len1, len2);
            int left = i-(len-1)/2;
          	int right = i+len/2;
            String curr = s.substring(left, right+1);
            if(curr.length()>result.length()) {
                result = curr;
            }
        }
        return result;
    }

    public static int expandPalindrome(String s, int left, int right) {
    	while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
    		left--;
    		right++;
    	}

    	return right - left - 1;
    }

    // this uses indexes for longest substring, not extra space(better)
    public static String longestPalindrome_constantSpace(String s) {
        if(s.length()<2) return s;
        int[] ans = {0, 0};
        int length = 0;
        for(int i=0; i<s.length(); i++) {
            length = expand(s, i, i);
            if(length>ans[1] - ans[0] + 1) {
                length/=2;
                ans[0]=i-length;
                ans[1]=i+length;
            }
            length = expand(s, i, i+1);
            if(length>ans[1] - ans[0] + 1) {
                length = length/2 - 1;
                ans[0]=i-length;
                ans[1]=i+1+length;
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }
    
    public static int expand(String s, int left, int right) {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}