import java.util.*;

class CycleSort {
	public static void main(String args[]) {
		int[] nums = {1,2,3,4,5,6};
		for(int i=0; i<5; i++) {
			shuffleNums(nums);
			printNums(nums);
			cyclicSort(nums);
			printNums(nums);
			System.out.println("------------------");
		}
	}

	public static int[] cyclicSort(int[] nums) {
		int i=0;
        while(i<nums.length) {
            if(nums[i]-1!=i) {
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            } else {
                i++;
            }
        }
        return nums;
	}

	public static void shuffleNums(int[] nums) {
		Random rand = new Random();
	    for (int i = nums.length - 1; i > 0; i--) {
	      int index = rand.nextInt(i + 1);
	      int val = nums[index];
	      nums[index] = nums[i];
	      nums[i] = val;
	  }
	}

	public static void printNums(int[] nums) {
    	for(int num: nums) {
    		System.out.print(num+", ");
    	}
    	System.out.println();
    }
}