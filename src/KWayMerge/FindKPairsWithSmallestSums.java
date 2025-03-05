import java.util.*;

class FindKPairsWithSmallestSums {
	public static void main(String args[]) {
		int[] nums1 = {3,4,8,9};
		int[] nums2 = {1,2,5,6};
		int k = 4;
		System.out.println(kSmallestPairs(nums1, nums2, k));
	}


	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]+a[1]) - (b[0]+b[1]));
		List<List<Integer>> result = new ArrayList<>();

		for(int i=0; i<Math.min(nums1.length,k); i++) {
			pq.offer(new int[]{nums1[i], nums2[0], 0});
		}

		while(result.size()<k && !pq.isEmpty()) {
			int[] pair = pq.poll(); //smallest pair;
			
			result.add(Arrays.asList(pair[0], pair[1]));
			
			int nums2Index = pair[2];
			if(nums2Index < nums2.length-1) {
				pq.offer(new int[]{pair[0], nums2[nums2Index+1], nums2Index+1});
			}
		}
		return result;
	}

	public static List<List<Integer>> kSmallestPairs_bruteForceOptimizeTimeLimitExceeds(int[] nums1, int[] nums2, int k) {
		PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b) -> (a.get(0)+a.get(1)) - (b.get(0)+b.get(1)));
		List<List<Integer>> result = new ArrayList<>();
		
		for(int i=0; i<nums1.length; i++) {
			for(int j=0; j<nums2.length; j++) {
				List<Integer> list = new ArrayList<>();
				list.add(nums1[i]);
				list.add(nums2[j]);
				pq.offer(list);
			}
			result.add(new ArrayList<>(pq.poll()));
			if(result.size()==k) {
				return result;
			}
		}
		while(result.size()!=k && !pq.isEmpty()) {
			result.add(pq.poll());
		}
		return result;
	}

	public static List<List<Integer>> kSmallestPairs_bruteForce(int[] nums1, int[] nums2, int k) {
		PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b) -> (a.get(0)+a.get(1)) - (b.get(0)+b.get(1)));

		for(int i=0; i<nums1.length; i++) {
			for(int j=0; j<nums2.length; j++) {
				List<Integer> list = new ArrayList<>();
				list.add(nums1[i]);
				list.add(nums2[j]);
				pq.offer(list);
			}
		}

		List<List<Integer>> result = new ArrayList<>();

		while(k-->0) {
			result.add(pq.poll());
		}
		return result;
	}


}