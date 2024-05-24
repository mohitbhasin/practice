class BigSum {
	public static void main(String args[]) {
		int arr[] = {1000000001, 1000000002, 1000000003, 1000000004, 1000000005};
		long result=0;/*Integer.MAX_VALUE;*/
		for(int a: arr) {
			result+=a;
		}
		System.out.println(result);
	}
}