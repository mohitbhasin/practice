
// Incorrect
class LongestRepeatingCharacterReplacement {
	public static void main(String args[]) {
		// String s = "AABABBA";
		// int k = 1;
		// String s = "ABAB";
		// int k = 2;
		// String s = "AAAB";
		// int k = 0;
		String s = "ABBB";
		int k = 2;

		System.out.println(characterReplacement(s, k));
	}

	public static int characterReplacement(String s, int k) {
        int tempK = 0;
        int prev = 0;
        int curr=0;
        int result = 0;
        while(curr<s.length()) {
        	System.out.println(curr);
            if(s.charAt(prev)==s.charAt(curr) || tempK < k) {
                if(s.charAt(prev)!=s.charAt(curr)) {
                    tempK++;
                }
            } else {
                result = Math.max(result, curr - prev);
                tempK--;
                prev=curr;
            }
            curr++;
        }
        result = Math.max(result, curr - prev);
        return result;
    }
}