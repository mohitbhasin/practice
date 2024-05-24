import java.util.*;

class MinimumAbsoluteDifference {
	public static void main(String args[]) {
		// int[] arr = {4,2,1,3};
		// int[] arr = {1,3,6,10,15};
		int[] arr = {3,8,-10,23,19,-4,-14,27};
		System.out.println(minimumAbsDifference(arr));
	}

	public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        
        int minDiff = Integer.MAX_VALUE;
        
        for(int i=1; i<arr.length; i++) {
            int diff = Math.abs(arr[i]-arr[i-1]);
            if(diff>minDiff) continue;
            if(diff<minDiff) {
                minDiff=diff;
                map.put(minDiff, new ArrayList<>());
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(arr[i-1]);
            temp.add(arr[i]);
            map.get(minDiff).add(temp);
        }
        
        return map.get(minDiff);
    }
}