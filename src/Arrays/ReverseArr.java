class ReverseArr {
	public static void main(String args[]) {
        int[] arr = {1,2,3,4,5,6,7};
        reverseInt(arr);
        for(int num: arr) {
            System.out.print(num+" ");
        }
    }

    public static void reverseInt(int[] arr) {
        for(int i=0; i<arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }
}