class Multiples {
	public static void main(String args[]) {
		System.out.println(findSumOfMultiples(1000));
	}

	public static int findSumOfMultiples(int n) {
		int sum=0;

		for(int i=0; i<n; i++) {
			if(i%3==0) {
				sum+=i;
			} else if(i%5==0) {
				sum+=i;
			}
		}

		return sum;
	}
}