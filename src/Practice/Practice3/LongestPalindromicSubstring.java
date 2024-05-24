class LongestPalindromicSubstring {
	public static void main(String args[]) {
		System.out.println(longPalindrome("jglknendsplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzifsknksogsbw"));
	}

	public static String longPalindrome(String s) {
		if(s.length()<3) {
			if(isPalindrome(s)) {
				return s;
			} else {
				return s.substring(0,1);
			}
		}

		String result="";
		for(int start=0; start<s.length(); start++) {
			for(int end=s.length()-1; end>start; end--) {
				String temp = s.substring(start, end+1);
				if(isPalindrome(temp) && temp.length() > result.length()) {
					result=temp;
				}
			}
		}

		return result.length()==0 ? s.substring(0,1) : result;
	}
	
	public static boolean isPalindrome(String s) {
		char[] chars = s.toCharArray();
		for(int i=0; i<s.length()/2; i++) {
			if(chars[i]!=chars[chars.length - i - 1]) {
				return false;
			}
		}
		return true;
	}
}