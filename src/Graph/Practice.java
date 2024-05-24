import java.util.*;

class Practice {
	public static void main(String args[]) {
		System.out.println(countOccurrences("thequickbrownfoxjumpsoverthelazydog", 'o'));
		System.out.println(firstUnique("thequickbrownfoxjumpsoverthelazydog"));
		int[] nums = {-1,-1,1};
		// System.out.println(numberOfSubArraySumToK(nums, 0));
		int[] nums2 = {4,5,12,8,65,5,12,99,65,0};
		for(int num: removeDuplicatesFromArray(nums2)) {
			System.out.print(num+", ");
		}
		System.out.println();
		int[] nums3 = {4,5,12,8,65,5,12,99,65,0};
		System.out.println(pairSumToK(nums3, 12));
		System.out.println(removeDupChar("helloworld"));
		System.out.println(simplePalindrome("lddl"));
		String s="ldadl";
		System.out.println(recurPalindrome(s, 0, s.length()-1));
		System.out.println(fibo(5));
	}

	public static int countOccurrences(String s, char c) {
		int count=0;

		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)==c) {
				count++;
			}
		}

		return count;
	}

	public static char firstUnique(String s) {
		//abcabb
		int[] occur = new int[26];
		for(int i=0; i<s.length(); i++) {
			int index=s.charAt(i) - 'a';
			occur[index]++;
		}

		for(int i=0; i<s.length(); i++) {
			int index=s.charAt(i) - 'a';
			if(occur[index]==1) {
				return s.charAt(i);
			}
		}
		return '\0';
	}

	public static int numberOfSubArraySumToK(int[] nums, int k) {
		int start=0;
		int end=0;
		int count=0;
		int tempSum=0;
		while(start<nums.length) {
			if(tempSum==k) {
				count++;
			} else if(end>=nums.length || tempSum>k) {
				start++;
				end=start;
				tempSum=0;
			} else {
				end++;
			}
			tempSum+=nums[end];
		}
		return count;
	}

	public static int[] removeDuplicatesFromArray(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		int curr=0;
		int prev=0;
		while(curr<nums.length) {
			if(!set.contains(nums[curr])) {
				set.add(nums[curr]);
				nums[prev++]=nums[curr];
			}
			curr++;
		}
		return Arrays.copyOf(nums, prev);
	}

	public static int pairSumToK(int[] nums, int k) {
		int count=0;
		for(int i=0; i<nums.length-1; i++) {
			for(int j=1; j<nums.length; j++) {
				if(nums[i]+nums[j]==k) {
					System.out.println(nums[i]+", "+ nums[j]);
					count++;
				}
			}
		}
		return count;
	}

	public static String removeDupChar(String s) {
		char[] chars = s.toCharArray();
		Set<Character> set = new HashSet<Character>();
		int curr=0;
		int prev=0;
		while(curr<chars.length) {
			if(!set.contains(chars[curr])) {
				set.add(chars[curr]);
				chars[prev++]=chars[curr];
			}
			curr++;
		}
		return new String(chars, 0, prev);
	}

	public static boolean simplePalindrome(String s) {
		for(int i=0; i<s.length()/2; i++) {
			if(s.charAt(i)!=s.charAt(s.length()-i-1)) {
				return false;
			}
		}
		return true;
	}

	public static boolean recurPalindrome(String s, int i, int j) {
		if(i>j) {
			return true;
		}
		if(s.charAt(i)!=s.charAt(j)) {
			return false;
		}
		return recurPalindrome(s, i+1, j-1);
	}

	public static int fibo(int i) {
		if(i<=0) {
			return 0;
		}
		if(i<2) {
			return 1;
		}

		return fibo(i-1)+fibo(i-2);
	}
}