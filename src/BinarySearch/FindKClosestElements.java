import java.util.*;

class FindKClosestElements {
	public static void main(String args[]) {
		// int[] arr = {1,2,3,4,6,9,10,12};
		// int k = 4;
		// int x = 3;
		int[] arr = {1,2,3,4,5};
		int k = 4;
		int x = 3;
        System.out.println(findClosestElements(arr, k, x));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length-k;

        List<Integer> result = new ArrayList<>();

        while(left<right) {
            int mid = left + (right-left)/2;
            if(x - arr[mid] > arr[mid+k] - x) {
                left=mid+1;
            } else {
                right=mid;
            }
        }
        for(int i=left; i<left+k; i++) {
        	result.add(arr[i]);
        }
        return result;
    }
}