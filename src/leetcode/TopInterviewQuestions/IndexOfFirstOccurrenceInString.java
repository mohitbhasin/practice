class IndexOfFirstOccurrenceInString {
	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
	}

	public static int strStr(String haystack, String needle) {
		for(int i=0; i<=haystack.length()-needle.length(); i++) {
			if(needle.equals(haystack.substring(i, i+needle.length()))) {
				return i;
			}
		}
		return -1;
    }
}