class ValidPalindromeII {
	public static void main(String args[]) {
		String[] strs = {"abca", "abcca","abfca"};
		for(String s: strs) System.out.println(validPalindromeConcise(s));
		System.out.println();
		for(String s: strs) System.out.println(validPalindrome(s));
	}

	public static boolean validPalindromeConcise(String s) {
		int l=0;
		int r=s.length()-1;

		while(l<r) {
			if(s.charAt(l)!=s.charAt(r)) {
				return checkPalindrome(s, l+1, r) || checkPalindrome(s, l, r-1);
			}
			l++;
			r--;
		}
		return true;
	}

	public static boolean checkPalindrome(String s, int l, int r) {
		while(l<r) {
			if(s.charAt(l)!=s.charAt(r)) return false;
			l++;
			r--;
		}
		return true;
	}

	public static boolean validPalindrome(String s) {
        return skipLeft(s) || skipRight(s);
    }
    
    public static boolean skipLeft(String s) {
        int l=0;
        int r=s.length()-1;
        boolean deleted = false;
        while(l<r) {
            if(s.charAt(l)!=s.charAt(r)) {
                if(!deleted) {
                    deleted=true;
                    l++;
                } else {
                    return false;
                }
            } else {
                l++;
                r--;
            }
        }
        return true;
    }
    
    public static boolean skipRight(String s) {
        int l=0;
        int r=s.length()-1;
        boolean deleted = false;
        while(l<r) {
            if(s.charAt(l)!=s.charAt(r)) {
                if(!deleted) {
                    deleted=true;
                    r--;
                } else {
                    return false;
                }
            } else {
                l++;
                r--;
            }
        }
        return true;
    }
}