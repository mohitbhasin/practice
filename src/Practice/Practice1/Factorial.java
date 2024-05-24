import java.util.Arrays;

class Factorial {
	public static void main(String args[]) {
		System.out.println(facto(5, 1));

        int[] nums = new int[] {1 , 3 , 6, 4, 1, 2};

        // System.out.println("Year having max population is "+findHighestPopulation(birth, death));
        System.out.println("missing number is " + missingPositiveNumber2(nums));
        // System.out.println("missing number is " + missingPositiveNumber(nums));

	}

	public static int facto(int num, int fact) {
		if(num<1) return fact;
		fact*=num;
		return facto(--num, fact);
	}

	public static int missingPositiveNumber(int[] nums) {
		boolean[] flags = new boolean[nums.length];

		for(int i=0; i<nums.length; i++) {
			if(nums[i]<1 || nums[i]>=nums.length) {
				continue;
			}
			flags[nums[i]]=true;
		}

		for(int i=1; i<nums.length; i++) {
			if(!flags[i]) {
				return i;
			}
		}

		return nums.length;
	}

	public static int missingPositiveNumber2(int[] nums) {
		Arrays.sort(nums);
		int currIndex=0;
		for(int i=1; i<nums.length; i++) {
			if(nums[i]<1) {

			} else {
				nums[currIndex]=nums[i];
				currIndex++;
			}
		}

		int temp=1;
		for(int i=0; i<currIndex; i++) {
			if(temp<nums[i]) {
				return temp;
			}
			else {
				temp++;
			}
		}
		return temp+1;
	}
}











