import java.util.*;

class KthLargestElement {
	public static void main(String args[]) {
		int[] nums = {3,2,3,1,2,4,5,5,6};
		System.out.println(kthElement(nums, 4));
	}

	public static int kthElement(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int n: nums) {
			pq.add(n);
			if(pq.size()>k) {
				pq.poll();
			}
		}

		return pq.poll();
	}
}