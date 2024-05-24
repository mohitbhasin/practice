import java.util.*;

class ShuffleAnArray {
	public static void main(String args[]) {
		int[] nums =  {1,2,3};
		Solution s = new Solution(nums);
		System.out.println(Arrays.toString(s.shuffle()));
		System.out.println(Arrays.toString(s.shuffle()));
		System.out.println(Arrays.toString(s.shuffle()));
		System.out.println(Arrays.toString(s.reset()));
	}
}

class Solution {
	String numString;
	int[] original;
	int[] nums;
	public Solution(int[] nums) {
		this.original = nums.clone();
		this.nums = nums;
	}

	public int[] reset() {        
        return original;
    }
    
    public int[] shuffle() {
        int rand =(int) (Math.random() * 10.0);

        int index = rand % nums.length;

        int temp = nums[index];
        nums[index] = nums[nums.length-1];
        nums[nums.length-1] = temp;
    	return nums;
    }

}