class CheckOnlyDigits {
	public static void main(String args[]) {
		System.out.println(checkString("-12568794302"));
		System.out.println(checkString2("-12568794302"));
	}

	public static boolean checkString(String s) {
		for(char c: s.toCharArray()) {
			if(c<'0' || c>'9') {
				return false;
			}
		}
		return true;
	}

	public static boolean checkString2(String s) {
		int start=0;
		if(s.charAt(start)=='-') {
			start++;
		}

		for(int i=start; i<s.length(); i++) {
			if(s.charAt(i)<'0' || s.charAt(i)>'9') {
				return false;
			}
		}

		return true;
	}
}