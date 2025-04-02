import java.util.*;

class KthSmallestNumberInMSortedLists {
	public static void main(String args[]) {
		List<List<Integer>> lists = new ArrayList<>();
		lists.add(Arrays.asList(4,6));
		lists.add(Arrays.asList(2,3));
		lists.add(Arrays.asList(8,9));
		int k = 3;
		System.out.println(kSmallestNumber(lists, k));
	}


	public static int kSmallestNumber(List<List<Integer>> lists, int k) {
        // 0 index = value index within list, 1th index = lists index
        PriorityQueue<int[]> minHeap = 
        new PriorityQueue<>((a,b) -> lists.get(a[1]).get(a[0]) - lists.get(b[1]).get(b[0]));
        // It is important not to check for i<=k in for loop.
        for(int i=0; i<lists.size(); i++) {
            if(lists.get(i).size()>0) {
                minHeap.offer(new int[]{0, i});
            }
        }
        int result = 0;
        while(!minHeap.isEmpty() && k>0) {
            int[] pair = minHeap.poll();
            int listIndex = pair[1];
            int valueIndex = pair[0];
            result = lists.get(listIndex).get(valueIndex);
            if(valueIndex+1<lists.get(listIndex).size()) {
                minHeap.offer(new int[]{valueIndex+1, listIndex});
            }
            k--;
        }
        return result;
    }
}
