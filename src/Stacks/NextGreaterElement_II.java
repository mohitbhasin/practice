import java.util.*;

class NextGreaterElement_II {
	public static void main(String args[]) {
		List<int[]> list = new ArrayList<>();
		list.add(new int[]{5,1,2,3,4,3});
		list.add(new int[]{1,1,1,1,1,1});
		list.add(new int[]{1,2,1});
		for(int[] nums: list) {
			for(int val: nextGreaterElements(nums)) {
				System.out.print(val+", ");
			}
			System.out.println();
		}
	}

	public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        int n = nums.length; //n = len or len-1, test run on leetcode
        for(int i=0; i<2*nums.length; i++) {
            if(!stack.isEmpty() && nums[stack.peek()]<nums[i%n]) {
            	result[stack.pop()] = nums[i%n ];
            }
            if(i<n) stack.push(i%n);
        }
        return result;
	}
}