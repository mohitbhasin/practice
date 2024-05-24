class ReverseArray {
	public static void main(String args[]) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		reverse(arr);
		for(int c: arr) {
			System.out.print(c + " ");
		}
		System.out.println();
		reverseForLoop(arr);
		for(int c: arr) {
			System.out.print(c + " ");
		}
		System.out.println();
		reverseWhile(arr);
		for(int c: arr) {
			System.out.print(c + " ");
		}
	}

	public static void reverseForLoop(int[] arr) {
        for(int i=0; i<arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }

	public static void reverseWhile(int[] arr) {
		int i=0;
		int temp=0;
		while(i<arr.length/2) {
			temp=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
			i++;
		}
	}

	public static void reverse(int[] arr) {
        int left=0;
        int right=arr.length-1;

        while(left<right) {
        	int temp = arr[left];
        	arr[left] = arr[right];
        	arr[right] = temp;
        	left++;
        	right--;
        }
    }
}