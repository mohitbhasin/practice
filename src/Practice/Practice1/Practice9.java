import java.util.HashSet;
import java.util.Set;

class Practice9 {
	public static void main(String args[]) {
		String s=" ";

		System.out.println(maxLengthOfsubString("pwwkew"));
		System.out.println(reverseNumer(10342364));

	}
	
	public static int maxLengthOfsubString(String s) {
		Set<Character> tempChars = new HashSet<Character>();
		if(s.length()<1) return 0;
		int maxLength=1;
		int beg=0;
		int end=0;
		while(end<s.length()) {
			if(tempChars.contains(s.charAt(end))) {
				maxLength=Math.max(maxLength, tempChars.size());
				tempChars.remove(s.charAt(beg++));
			} else {
				tempChars.add(s.charAt(end++));
			}
		}
		return Math.max(maxLength, tempChars.size());
	}

	public static int reverseNumer(int num) {
		int result = 0;
		int sign= num<0?-1:1;
		while(num!=0) {
			result = result *10 + num%10;
			num/=10;
		}

		return result;
	}
}