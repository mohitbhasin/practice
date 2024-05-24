class Recur1 {
	public static void main(String args[]) {
		// String s="m";
		// System.out.println(s.substring(0,1));
		printReverseString("mohit");
	}

	public static void printReverseString(String str) {
		if(str==null || str.length()<=0) {
			return;
		}
		int last = str.length()-1;
		System.out.println(str.charAt(last));
		printReverseString(str.substring(0, last));
	}
}