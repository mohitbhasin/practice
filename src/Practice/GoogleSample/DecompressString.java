class DecompressString {
	public static void main(String[] args) {
		String s = "3[abc]4[ab]c";
		System.out.println(decodeString(s));
	}
	static int index = 0;
	public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        while(index<s.length() && s.charAt(index) != ']') {
            if(Character.isLetter(s.charAt(index))) {
                sb.append(s.charAt(index++));
            } else {
                int val = 0;
                while(index < s.length() && Character.isDigit(s.charAt(index))) {
                    val*=10;
                    val+=s.charAt(index++) - '0';
                }
                index++;
                String decoded = decodeString(s);
                index++;
                while(val-->0) {
                    sb.append(decoded);
                }
            }
        }
        return sb.toString();
    }
}