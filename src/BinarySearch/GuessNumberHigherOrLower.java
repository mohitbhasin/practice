class GuessNumberHigherOrLower {
	static int pick;
	public static void main(String[] args) {
		pick=6;
		System.out.println(guessNumber(10));
		pick=21473647;
		System.out.println(guessNumber(2147483647));
	}

	public static int guessNumber(int n) {
        int left = 1;
        int right = n;
        
        while(left<=right) {
            int mid = left + (right-left)/2;
            int result = guess(mid);
            if(result==0) return mid;
            else if(result>0) left=mid+1;
            else right=mid-1;
        }
        return -1;
    }

    public static int guess(int val) {
    	if(val>pick) return -1;
    	else if(val<pick) return 1;
    	else return 0;
    }
}