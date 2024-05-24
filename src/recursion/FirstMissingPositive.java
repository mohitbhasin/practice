class FirstMissingPositive {
	public static void main(String args[]) {
		int a=1;
		if(a>>1==0) {

		}
		System.out.println(a>>1);
	}

	public int firstMissingPositive(int[] nums) {
		int temp=0;

		for(int n: nums) {
			if(n<=0) {
				continue;
			}
			temp+=n;
		}
		int result=0;
		while(temp>0) {
			int bit=temp>>1;
			if(bit==0) {
				break;
			}
			
		}
		return 0;
    }
}
