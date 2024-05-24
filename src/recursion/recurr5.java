class recurr5 {
	public static void main(String args[]) {
		int nums[] = new int[] {1,0,0,1,0,0,1,1,1,0,0,0,0,0,0};
		int result = 0;
		for(int num: nums) {
			result<<=1;
			result+=num;
		}
		System.out.println(result);
	}
}