import java.util.*;

class CircularArrayLoop {
	public static void main(String args[]) {
		List<int[]> list = new ArrayList<>();
		list.add(new int[]{1,3,4,2,2});
		list.add(new int[]{3,4,4,4,2});
		list.add(new int[]{1,1});
		list.add(new int[]{1,2,2});
		list.add(new int[]{3,1,3,4,2});
		list.add(new int[]{1,3,-2,-4,1});
		list.add(new int[]{2,1,-1,-2});
		list.add(new int[]{5,4,-2,-1,3});
		list.add(new int[]{3,3,1,-1,2});
		for(int[] nums: list) System.out.println(circularArrayLoop(nums));
	}


   	public static boolean circularArrayLoop(int[] nums) {
     	for(int i=0; i<nums.length; i++) {
			if(nums[i]==0) continue;
		    int slow = i;
		    int fast = i;
		    boolean forward = nums[i]>0;
		  	
		    while(true) {
  				slow = nextJump(slow, nums[slow], nums.length);
  				// if the jumped index value has different direction then break (not return false).
  				// If false is returned then rest of the elements will be skipped.
  				if(validateCycle(forward, slow, nums)) break;
  				fast = nextJump(fast, nums[fast], nums.length);
  				if(validateCycle(forward, fast, nums)) break;
  				fast = nextJump(fast, nums[fast], nums.length);
  				if(validateCycle(forward, fast, nums)) break;
  				if(slow==fast) return true;
		    }
		}
		return false;
	}

	// calculating next jump within bounds. if jump becomes negative then rotating it.
	public static int nextJump(int index, int value, int size) {
		int jump = (index + value) % size;
		if(jump<0) {
			jump+=size;
		}
		return jump;
	}

	public static boolean validateCycle(boolean direction, int index, int[] nums) {
		boolean currDir = nums[index]>=0;
		// nums[index] % nums.length == 0 checks for jump on the same element.
		// in another words, cycle with only one element.
		if(currDir!=direction || nums[index]%nums.length==0) {
			return true;
		}
		return false;

	}
}