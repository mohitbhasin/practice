class ValidPerfectSquare {
	public static void main(String args[]) {
		int[] nums = {16, 36, 1, 2, 3, 4, 56, 49, 80};
		for(int num: nums) System.out.println(num+":"+isPerfectSquare(num));
	}

	public static boolean isPerfectSquare(int num) {
        if(num==1) return true;
        int left = 1;
        int right = num/2;
        
        while(left<=right) {
            int mid = (left+right)/2;
            if(mid*mid==num) return true;
            if(Integer.MAX_VALUE/mid < mid || mid*mid>num) {
                right=mid-1;
            } else {
                left=mid+1;
            }
        }
        return false;
    }
}