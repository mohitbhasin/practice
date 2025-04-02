import java.util.*;

class KthLargestElementInAnArray {
	public static void main(String args[]) {
		int[] nums = {4,12,5,-1,2,-5,6,-4};
		int k = 5;
		System.out.println(findKthLargest(nums, k));
	}

	public static int findKthLargest(int[] nums, int k) {
	   PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
	   for(int val: nums) {
	       maxHeap.offer(val);
	       if(maxHeap.size()>k) {
	           maxHeap.poll();
	       }
	   }
	   return maxHeap.peek();
	}
}