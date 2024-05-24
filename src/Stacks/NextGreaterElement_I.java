import java.util.*;

class NextGreaterElement_I {
	public static void main(String args[]) {
		int[][] nums = {
			{4,1,2},
			{1,3,4,2},
			{2,4},
			{1,2,3,4},
			{1,3,5,2,4},
			{6,5,4,3,2,1,7}
		};

		for(int i=0; i<nums.length; i+=2) {
			for(int num: nextGreaterElement(nums[i], nums[i+1])) {
				System.out.print(num+", ");
			}
			System.out.println();
		}
	}

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<nums2.length; i++) {
            if(stack.isEmpty() || stack.peek()>nums2[i]) {
                stack.push(nums2[i]);
            } else {
                while(!stack.isEmpty() && stack.peek()<nums2[i]) {
                    map.put(stack.pop(), nums2[i]);
                }
                stack.push(nums2[i]);
            }
        }
        
        for(int i=0; i<nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}