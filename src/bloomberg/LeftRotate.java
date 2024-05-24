class LeftRotate {
	public static void main(String args[]) {
		int[] nums = {1,2,3,4,5};
		printRotate(nums, 2);
		System.out.println("\n-------------");
		for(int n: rotate(nums,5)) {
			System.out.print(n+" ");
		}
		rotateItself(nums,3);
		System.out.println("\n-------------");
		for(int n: nums) {
			System.out.print(n+" ");
		}
	}

	//Just print, not updating array
	public static void printRotate(int[] nums, int k) {
		int n = nums.length;
		int mod = k % n;

		for(int i=0; i<n; i++) {
			System.out.print(nums[(mod+i)%n] + " ");
		}
	}

	// rotate/copy in new array
	public static int[] rotate(int[] nums, int k) {
		int n = nums.length;
		int mod = k % n;
		int[] result = new int[n];

		for(int i=0; i<n; i++) {
			result[i]=nums[(mod+i)%n];
		}

		return result;
	}

	// rotate itself with temp arry of size k
	public static void rotateItself(int[] nums, int k) {
		int n=nums.length;
		int[] temp = new int[k%n];
		int mod=k%n;
		for(int i=0; i<temp.length; i++) {
			temp[i]=nums[i];
		}
		for(int i=0; i<nums.length-temp.length; i++) {
			nums[i] = nums[(i+mod)%n];
		}
	}
}