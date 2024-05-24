import java.util.*;

class SummaryRanges {
	public static void main(String args[]) {
		int[][] numsArr = {{0,1,2,4,5,7},{0,2,3,4,6,8,9}};

		for(int[] nums: numsArr) {
			System.out.println(summaryRanges(nums));
		}


	}

	public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums.length==0) return result;
        String range = ""+nums[0];
        
        for(int i=1; i<nums.length; i++) {
            if(nums[i]!=nums[i-1]+1) {
                if(!range.equals(""+nums[i-1])) range+="->"+nums[i-1];
                result.add(range);
                range=""+nums[i];
            }
        }
        if(!range.equals(""+nums[nums.length-1])) {
            range+="->"+nums[nums.length-1];
        }
        result.add(range);
           return result;
    }
}