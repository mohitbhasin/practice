class ConverstStringToInt {
	public static void main(String args[]) {
		System.out.println(convert("-454654324"));
	}

	public static int convert(String s) {
		int result=0;
		int sign=1;
		int i=0;
		if(s.charAt(i) == '-') {
			i=1;
			sign=-1;
		}
		while(i<s.length()) {
			char c = s.charAt(i++);
			int temp = c - '0';

			result = (result*10)  + temp;

		}

		return result*sign;
	}
}