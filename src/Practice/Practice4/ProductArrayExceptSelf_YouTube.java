// Leetcode 238: Product of Array Except Self
// Youtube Nick White

class ProductArrayExceptSelf_YouTube {
	public static void main(String args[]) {
		product(new int[]{1,2,3,4});
		System.out.println("-----");
		product(new int[]{1,2,3,4});
	}

	public static int[] product(int[] nums) {
		int[] result=new int[nums.length];
		for(int i=0; i<nums.length; i++) {
			int prod=1;
			for(int j=0; j<nums.length; j++) {
				if(i==j) {
					continue;
				}
				prod*=nums[j];
			}
			result[i]=prod;
		}

		for(int num: result) {
			System.out.print(num+"\t");
		}
		return result;
	}
// Without using divistion 
	public static int[] product2(int[] nums) {
		// int[] left = new int[nums.length];
		// int[] right = new int[nums.length];
		// int[] result = new int[nums.length];

		// int temp=1;
		// for(int i=0; i<nums.length; i++) {
		// 	temp*=nums[i];
		// 	left[i]=temp;
		// }
		// for(int i=nums.length; i>=0; i--) {
		// 	temp*=nums[i];
		// 	left[i]=temp;
		// }
		// for(int i=0; i<nums.length; i++) {
		// 	result[i]=left[i]*right[i];
		// }
		// for(int num: result) {
		// 	System.out.print(num+"\t");
		// }
		// return result;
		return null;
	}
}