class PartitionUptoM {
	public static void main(String args[]) {
		System.out.println(helper(5,5));
	}

	public static int helper(int n, int m) {
		if(n==0) {
			return 1;
		}
		if(m==0 || n<0) {
			return 0;
		}
		return helper(n-m, m) + helper(n,m-1);

	}
}