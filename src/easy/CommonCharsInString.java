class CommonCharsInString {
	public static void main(String args[]) {
		String[] s = {"bella","label","roller"};
		System.out.println(getCommonChars(s));
	}

	public static char[] getCommonChars(String[] s) {
		return helper(s, 1, s[0]).toCharArray();
	}

	public static String helper(String[] s, int index, String result) {
		if(index>=s.length) {
			return result;
		}

		char[] chars = result.toCharArray();
		StringBuilder sb = new StringBuilder();

		for(char c1: s[index].toCharArray()) {
			for(int i=0; i<chars.length; i++) {
				if(c1==chars[i]) {
					sb.append(c1);
					chars[i]='0';
				}
			}
		}
		
		return helper(s, index+1, sb.toString());
	}
}