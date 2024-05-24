import java.util.*;

class IntersectionOfTwoArraysII {
	public static void main(String args[]) {
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		for(int val: intersect(nums1, nums2)) System.out.print(val+", ");
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums2.length; i++) {
            if(map.containsKey(nums2[i])) {
                result.add(nums2[i]);
                if(map.get(nums2[i])==1) map.remove(nums2[i]);
                else map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
        int[] arr = new int[result.size()];
        for(int i=0; i<result.size(); i++) arr[i]=result.get(i);
        return arr;
    }
}