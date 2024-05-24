class PrintReverse {
	public static void main(String[] s) {
		print("Mohit", 0);
	}

	public static void print(String s, int i) {
		if(i>=s.length()) {
			return;
		}
		System.out.print(s.charAt(s.length()-i-1));
		print(s, i+1);
	}
}