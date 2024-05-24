class MaximumNestingDepthOfTheParentheses {
	public static void main(String atgs[]) {
		String[] strs = {"(1+(2*3)+((8)/4))+1", "(1)+((2))+(((3)))"};
		for(String str: strs) System.out.println(maxDepth(str));
	}

	public static int maxDepth(String s) {
        int count = 0;
        int maxDepth = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') {
                count++;
            } else if(s.charAt(i)==')') {
                maxDepth = Math.max(count, maxDepth);
                count--;
            }
        }
        return maxDepth;
    }
}