import java.util.*;

class KthLargestElement {
	public static void main(String args[]) {
		Soulution s = new Soulution();
		s.kthLargest(3, new int[]{4, 5, 8, 2});
		System.out.println(s.add(3));
		System.out.println(s.add(5));
		System.out.println(s.add(10));
		System.out.println(s.add(9));
		System.out.println(s.add(4));
	}

	
}

class Soulution {
	PriorityQueue<Integer> queue;
	int K;
	public void kthLargest(int k, int[] nums) {
		K=k;
		// queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
		// 	public int compare(Integer a, Integer b) {
		// 		if(a>b) {
		// 			return 1;
		// 		}
		// 		return -1;
		// 	}
		// });

		//OR default comparator 

		queue = new PriorityQueue<Integer>();

		for(int num: nums) {
			queue.offer(num);
			if(queue.size()>k) {
				queue.poll();
			}
		}
		System.out.println(queue);

	}

	public int add(int val) {
		queue.offer(val);
		if(queue.size()>K) {
				queue.poll();
		}
		return queue.peek();
	}
}