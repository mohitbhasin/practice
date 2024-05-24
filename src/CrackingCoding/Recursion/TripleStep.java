class TripleStep {
	public static void main(String args[]) {
		System.out.println(countSteps(3, 0));
	}

	public static int countSteps(int n, int curr) {
		if(curr==n) {
			return 1;
		}
		if(curr>n) {
			return 0;
		}
		return countSteps(n, curr+1) + countSteps(n, curr+2) + countSteps(n, curr+3);
	}
}