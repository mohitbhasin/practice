class StringCompression {
	public static void main(String args[]) {
		System.out.println(compress("aabcccccaaa"));
		System.out.println(compressUsingForLoop("aabcccccaaa"));
	}

/// missing last count
	public static String compress(String s) {
		int pre=0;
		int curr=0;
		int count=0;
		StringBuilder sb = new StringBuilder();
		while(curr<s.length()) {
			count++;
			if(s.charAt(pre)!=s.charAt(curr)) {
				sb.append(s.charAt(pre));
				sb.append(count);
				pre=curr;
				count=0;
			}
			if(sb.length()>=s.length()) {
				return s;
			}			
			curr++;
		}

		sb.append(s.charAt(pre));
		sb.append(count);
		return sb.toString();
	}

	public static String compressUsingForLoop(String s) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<s.length(); i++) {
			count++;
			if(i+1>=s.length() || s.charAt(i)!=s.charAt(i+1)) {
				sb.append(s.charAt(i));
				sb.append(count);
				count=0;
			}
			if(sb.length()>s.length()) return s;
		}
		return sb.toString();
	}
}