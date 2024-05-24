class StringToInteger {
	public static void main(String args[]) {
		String s="1597";
		System.out.println(convert(s));
	}

	public static int convert(String s) {
		int result=0;
		for(int i=0; i<s.length(); i++) {
			result*=10;
			result+=Character.getNumericValue(s.charAt(i));
		}
		return result;
	}
}