import java.util.*;

class KthSmallestElementInASortedMatrix {
	public static void main(String args[]) {
		List<int[][]> matrixList = new ArrayList<>();
		List<Integer> kList = new ArrayList<>();
		matrixList.add(new int[][]{{1,5,9},{10,11,13},{12,13,15}});
		kList.add(8);
		matrixList.add(new int[][]{{1,2},{1,3}});
		kList.add(2);
		matrixList.add(new int[][]{{2,4,8},{5,6,10},{6,7,18}});
		kList.add(4);
		for(int i=0; i<matrixList.size(); i++) {
	    	System.out.println(kthSmallest(matrixList.get(i), kList.get(i)));
		}
	}

	// Time complexity = O(k + k*log(k))
	// Space Complexity = O(k)
	public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        for(int i=0; i<matrix.length && i<=k; i++) {
        	minHeap.offer(new int[] {matrix[i][0], i, 0});
        }
        int result = Integer.MIN_VALUE;
        while(!minHeap.isEmpty() && k>0) {
        	int[] curr =minHeap.poll();
        	result = curr[0];
        	int i = curr[1];
        	int j = curr[2]+1;
        	if(j<matrix[i].length) {
        		minHeap.offer(new int[]{matrix[i][j], i, j});
        	}
        	k--;
        }
        return result;
    }
}