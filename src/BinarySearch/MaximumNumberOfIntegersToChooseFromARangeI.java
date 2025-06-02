import java.util.*;

class MaximumNumberOfIntegersToChooseFromARangeI {
	public static void main(String args[]) {
		List<int[]> bannedList = new ArrayList<>();
		List<Integer> nList = new ArrayList<>();
		List<Integer> maxSumList = new ArrayList<>();

		bannedList.add(new int[]{1,6,5});
		nList.add(5);
		maxSumList.add(6);
		bannedList.add(new int[]{1,2,3,4,5,6,7});
		nList.add(8);
		maxSumList.add(1);
		bannedList.add(new int[]{2,4});
		nList.add(5);
		maxSumList.add(10);

		for(int i=0; i<nList.size(); i++) {
			System.out.println(maxCount_binarySearch(bannedList.get(i), nList.get(i), maxSumList.get(i)));
			System.out.println(maxCount(bannedList.get(i), nList.get(i), maxSumList.get(i)));
			System.out.println("------------");

		}
	}

	// Iterative approach better (time complexity - O(m+n))
	public static int maxCount(int[] banned, int n, int maxSum) {
        int[] arr = new int[10001];
        for(int val: banned) {
            arr[val]++;
        }
        int count = 0;
        int sum = 0;
        
        for(int i=1; i<=n; i++) {
            if(arr[i]==0) {
                if(sum+i>maxSum) {
                    return count;
                }
                sum+=i;
                count++;
            }
        }
        return count;
    }

	// Not preferred - Binary search not ideal for this problem
	public static int maxCount_binarySearch(int[] banned, int n, int maxSum) {
		Arrays.sort(banned);

		int currSum = 0;
		int val = 1;
		int count = 0;
		while(val<=n) {
			// check if curr val can be added
			if(val+currSum<=maxSum) {
				if(!isBanned(val, banned)) {
					currSum+=val;
					count++;
				}
			} else {
				return count;
			}
			val++;
		}

		return count;
	}

	public static boolean isBanned(int target, int[] banned) {
		int left = 0;
		int right = banned.length-1;

		while(left<=right) {
			int mid = left+((right-left)/2);
			if(banned[mid]==target) {
				return true;
			} else if(banned[mid]<target) {
				left=mid+1;
			} else {
				right=mid-1;
			}
		}
		return false;
	}
}