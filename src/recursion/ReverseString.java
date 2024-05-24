class ReverseString {
	public static void main(String args[]) {
		String s = "hello";
		char[] chars = s.toCharArray();
		reverseString(chars);
		for(char c: chars) {
			System.out.print(c+", ");
		}
	}

	public static void reverseString(char[] s) {
        swap(s, 0, s.length-1);
    }

    public static void swap(char[] s, int left, int right) {
    	if(left>=right) return;
    	char temp = s[left];
    	s[left] = s[right];
    	s[right] = temp;
    	swap(s, ++left, --right);
    }
}