package leetcode.medium;

public class LongestSubtringWithoutRepeatingCharacter {
	public static void main(String args[]) {
		int[] arr = {2,4,7,13,13,45,45,56};
		System.out.println(findFirstOccurence(arr, 45));
	}
	
	public static int findFirstOccurence(int[] arr, int k) {
		int left=0;
		int right=arr.length-1;
		int mid=(right+left)/2;
		int result=-1;
		while(left<right) {
			System.out.println("----while--mid="+mid);
			if(arr[mid]==k) {
				System.out.println("if");
				result=mid;
				System.out.println(mid+"----"+result);
				right=mid-1;
				mid=(right+left)/2;
			} else if(arr[mid]<k) {
				System.out.println("else if");
				right=mid;
				mid=(right+left)/2;
			} else {
				System.out.println("else");
				left=mid+1;
				mid=(right+left)/2;
			}
		}
		return result;
	}
}
