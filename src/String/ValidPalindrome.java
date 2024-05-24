class ValidPalindrome {
	public static void main(String args[]) {
		// String s = "rac3car";
		// String s = "A man, a plan, a canal: Panama";
		String s = "race a car";
		System.out.println(isPalindrome(s));
	}

	public static boolean isPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        
        while(l<r) {
            char a = s.charAt(l);
            char b = s.charAt(r);
            // !Character.isLetterOrDigit(a) can be used
            if(!((a>='a' && a<='z') || (a>='A' && a<='Z') || (a>='0' && a<='9'))) {
                l++;  
            }
            else if(!((b>='a' && b<='z') || (b>='A' && b<='Z') || (b>='0' && b<='9'))) {
                r--;
            } else {
                a = Character.toLowerCase(a);
                b = Character.toLowerCase(b);
                if(a!=b) return false;
                l++;
                r--;
            }
        }
        return true;
    }
}