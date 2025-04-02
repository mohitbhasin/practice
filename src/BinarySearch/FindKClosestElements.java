import java.util.*;

class FindKClosestElements {
	public static void main(String args[]) {
		// int[] arr = {1,2,3,4,6,9,10,12};
		// int k = 4;
		// int x = 3;
        // int[] arr = {1,2,3,4,5};
        // int k = 4;
        // int x = 3;
        // int[] arr = {0,0,1,2,3,3,4,7,7,8};
        // int k = 3;
        // int x = -1;
        // int[] arr = {-10,-6,-4,-3};
        // int k = 2;
        // int x = 5;
        // int[] arr = {1};
        // int k = 1;
        // int x = 1;
        // int k = 838;
        // int x = -4448;
        // int[] arr = {-2,-1,1,2,3,4,5};
        // int k = 7;
        // int x = 3;
        // int[] arr = {1,3};
        // int k = 1;
        // int x = 2;
		int[] arr = {0,2,5,7,9,10,12,14,16,17,19,22,25};
		int k = 2;
		int x = 19;
        System.out.println(findClosestElements(arr, k, x));
        // System.out.println(findClosestElements_error_prone(arr, k, x));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length-k;

        List<Integer> result = new ArrayList<>();

        while(left<right) {
            int mid = left + (right-left)/2;
            System.out.println(left+":"+mid+":"+right);
            System.out.println((mid+k)+"--->"+arr[mid]+" ? "+arr[mid+k]);
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

    public static List<Integer> findClosestElements_error_prone(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr.length==k) {
            for(int val: arr) {
                result.add(val);
            }
            return result;
        }
        if(x<arr[0]) {
            for(int i=0; i<k; i++) {
                result.add(arr[i]);
            }
            return result;
        }
        if(x>arr[arr.length-1]) {
            for(int i=arr.length-1; i>=arr.length-k; i--) {
                result.add(0, arr[i]);
            }
            return result;
        }
        int left=0;
        int right=arr.length-1;

        while(left<right-1) {
            int mid = left + (right - left)/2;
            if(arr[mid]==x) {
                left=mid;
                break;
            }
            if(arr[mid]>x) {
                right=mid;
            } else {
                left=mid;
            }
        }
        if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
            right = left;
        } else {
            left = right;
        }
        result.add(arr[left]);
        left--;
        right++;

        while(result.size()<k && (left>=0 || right<arr.length)) {
            if(left>=0 && right<arr.length) {
                int diff_left = Math.abs(arr[left]-x);
                int diff_right = Math.abs(arr[right]-x);
                if(diff_left <= diff_right) {
                    result.add(0,arr[left]);
                    left--;
                } else if(diff_right<diff_left) {
                    result.add(arr[right]);
                    right++;
                }
            } else if(left>=0) {
                result.add(0, arr[left]);
                left--;
            } else {
                result.add(arr[right]);
                right++;
            }
        }
        return result;
    }
}