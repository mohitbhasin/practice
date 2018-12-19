package leetcode.explore.ArrayString;

public class PivotIndex {
	
	/// not every test case passed
	public static void main(String args[]) {
		int[] nums = {-1,-1,-1,-1,-1,-1};
		System.out.println(findPivot(nums));
	}
	
	public static int findPivot(int[] nums) {
		int i = 0;
		int j = nums.length-1;
        if(nums.length < 3 || nums == null) {
            return -1;
        }
		int sumLeft = nums[i], sumRight  = nums[j];
		while(i!=j) {
			System.out.println(sumLeft + " " + sumRight);
			if(sumLeft > sumRight) {
				sumRight = sumRight + nums[--j];
			} else if (sumLeft < sumRight) {
				sumLeft = sumLeft + nums[++i];
			} else if(sumRight == sumLeft) {
				return ++i;
			}
		}
		return -1;
	}
}
