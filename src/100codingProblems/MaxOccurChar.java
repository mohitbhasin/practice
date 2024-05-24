class MaxOccurChar {
	public static void main(String args[]) {
		String s="asjdhaskjbjvsdlkjvhakjdhakjshb";
		System.out.println(maxOccurrence(s));
	}

	public static char maxOccurrence(String s) {
		int[] set = new int[26];
		int max=Integer.MIN_VALUE;
		int temp;
		int resultIndex=-1;
		for(int i=0; i<s.length(); i++) {
			temp=s.charAt(i) - 'a';
			set[temp]++;
			max=Math.max(max, set[temp]);
		}
		for(int i=0; i<set.length; i++) {
			if(set[i]==max) {
				resultIndex=i;
				break;
			}
		}
		return (char) ('a'+resultIndex);

	}
}