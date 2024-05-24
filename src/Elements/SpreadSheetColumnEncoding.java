class SpreadSheetColumnEncoding {
	public static void main(String args[]) {
		System.out.println(convert("AAA"));
	}

	public static int convert(String col) {
		int result = 0;

		for(int i=0; i<col.length(); i++) {
			char c = col.charAt(i);
			result = result * 26 + c - 'A' + 1;
		}

		return result;
	}
}