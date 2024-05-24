class TripleStep {
	public static void main(String args[]) {
		System.out.println(countWays(3, 0));
	}

	public static int countWays(int n, int count) {
		if(n==0) {
			return 1;
		}
		if(n<0) {
			return 0;
		}
		return countWays(n-1, count) + countWays(n-2, count) + countWays(n-3, count);
	}

}