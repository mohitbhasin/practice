class ProductArrayExceptSelf {
	public static void main(String args[]) {
		int[][] numsArray = {{1,2,3,4},{-1,1,0,-3,3},{0,0,0,0},{0,4,0},{1,0}};

		for(int[] nums: numsArray) {
			for(int num: productExceptSelf(nums)) {
				System.out.print(num+", ");
			}
	        System.out.println();
		}
	}


	// {1, 1, 2, 6}
	// {24,12,4,1}
	// ans: {24, 12, 8, 6}
	public static int[] productExceptSelf(int[] nums) {
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        // Left side prodcut except self
        int temp = 1;
        for(int i=0; i<nums.length; i++) {
            L[i]=temp;
            temp*=nums[i];
        }
        // Right side prodcut except self
        temp = 1;
        for(int i=nums.length-1; i>=0; i--) {
            R[i]=temp;
            temp*=nums[i];
        }
        // for(int num: L) System.out.print(num+" ");
        // System.out.println();
        // for(int num: R) System.out.print(num+" ");
        // System.out.println();
        for(int i=0; i<nums.length; i++) {
        	nums[i]=L[i]*R[i];
        }
        return nums;
    }
    // {1, 2, 3, 4}
	// {1, 1, 2, 6}
	// {24,12,4,1}
	// ans: {24, 12, 8, 6}
    public static int[] productExceptSelf_ConstanceSpace(int[] nums) {
        int[] result = new int[nums.length];
        // Left side prodcut except self
        int temp = 1;
        for(int i=0; i<nums.length; i++) {
        	result[i]=temp;
            temp*=nums[i];
        }
        // for(int num: result) System.out.print(num+" ");
        // System.out.println();
        // updating final result with temp acting as right side product
        temp = 1;
        for(int i=nums.length-1; i>=0; i--) {
            result[i]=result[i]*temp;
        	temp*=nums[i];
        }
        return result;
    }
}