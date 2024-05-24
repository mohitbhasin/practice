class RotateMatrix {
	public static void main(String args[]) {
		int[] arr = {1,2,3,4,5};
		// rotateBrute(arr,12);
		// rotateCircular(arr,1);
		rotateReverse(arr, 11);
		System.out.println("------");
		for(int a: arr) {
			System.out.print(a+", ");
		}
	}

	public static void rotateBrute(int[] arr, int k) {
		int mod = k % arr.length;
		for(int j=0; j<mod; j++) {
			int prev = arr[arr.length - 1];
			for(int i=0; i<arr.length; i++) {
				int temp = arr[i];
				arr[i] = prev;
				prev = temp;
			}
		}
	}

	public static void rotateReverse(int[] nums, int k) {
		k=k%nums.length;
        reverse(nums, 0, nums.length-1);
		reverse(nums, k, nums.length - 1);
        reverse(nums, 0, k-1);
    }
    
    private static void reverse(int[] nums, int start, int end) {
        while(start<end) {
        	int temp = nums[start];
        	nums[start++] = nums[end];
        	nums[end--] = temp;
        }
    }

	public static void rotateCircular(int[] arr, int k) {
		int count=0;
		int i=0;
		int n=arr.length;
		int temp;
		while(count<arr.length) {
			temp = arr[(i+k)%n];
			arr[(i+k)%n] = arr[i];
			arr[i] = temp;
			i=(i+k)%n;
			count++;
		}
	}
}