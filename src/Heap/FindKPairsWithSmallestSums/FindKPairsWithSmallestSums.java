import java.io.*;
import java.util.*;

// Slow/ Incorrect
class FindKPairsWithSmallestSums {
	public static void main(String args[]) {
		BufferedReader br;
		int[] nums1 = new int[10000];
		int[] nums2 = new int[10000];
		int k=0;
		try {
			br = new BufferedReader(new FileReader("data.txt"));
			String[] numString = br.readLine().split(",");
			for(int i=0; i<numString.length; i++) {
				nums1[i] = Integer.valueOf(numString[i]);
			}
			numString = br.readLine().split(",");
			for(int i=0; i<numString.length; i++) {
				nums2[i] = Integer.valueOf(numString[i]);
			}
			k=Integer.valueOf(br.readLine());
		} catch(Exception e) {

		}
		System.out.println(kSmallestPairs(nums1, nums2, k));
	}

	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0]+b[1]) - (a[0]+a[1]));
        for(int i=0; i<nums1.length && i<k; i++) {
            for(int j=0; j<nums2.length && j<k; j++) {
            	int sum = nums1[i]+nums2[j];
            	if(i+1<nums1.length && sum>nums1[i+1]+nums2[0]) break;
                pq.offer(new int[] {nums1[i], nums2[j]});
                if(pq.size()>k) pq.poll();   
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for(int[] pair: pq) result.add(Arrays.asList(pair[0], pair[1]));
                                                              
        return result;
    }
}