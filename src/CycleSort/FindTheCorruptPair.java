import java.util.*;

class FindTheCorruptPair {
	public static void main(String args[]) {
		List<int[]> list = new ArrayList<>();
		list.add(new int[]{3,1,2,3,4,6});
		list.add(new int[]{3,1,2,3,5,6});
		list.add(new int[]{3,1,2,3,5,4});
		list.add(new int[]{3,3,2,6,5,4});


		for(int[] nums: list) {
			for(int val: findCorruptPair(nums)) {
				System.out.print(val+":");
			}
			System.out.println();
		}
	}

	public static int[] findCorruptPair(int[] nums) {
       int i=0;
       int[] result = new int[2];
       while(i<nums.length) {
           if(nums[i]-1!=i) {
               int temp = nums[i];
               nums[i] = nums[temp-1];
               nums[temp-1] = temp;
               if(nums[i]==temp) {
                   i++;
               }
           } else {
               i++;
           }
       }
       for(int j=0; j<nums.length; j++) {
           if(nums[j]!=j+1) {
               result[0]=j+1;
               result[1]=nums[j];
           }
       }
       return result;
   }
}