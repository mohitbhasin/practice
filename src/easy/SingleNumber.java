import java.util.*;

class SingleNumber {
	public static void main(String args[]) {
		int[][] numMat = {{2,2,1}, {4,1,2,1,2}, {1}};
		for(int[] nums: numMat) System.out.println(singleNumber(nums));
		System.out.println();
		for(int[] nums: numMat) System.out.println(singleNumber_slow(nums));
	}


//     If we take XOR of zero and some bit, it will return that bit
//         a⊕0=a
//     If we take XOR of two same bits, it will return 0
//         a⊕a=0
//     a⊕b⊕a=(a⊕a)⊕b=0⊕b=b

// So we can XOR all bits together to find the unique number. This is O(n) solution with O(1) space

	public static int singleNumber(int[] nums) {
        int result=0;
        for(int num: nums) {
            result^=num;
        }
        return result;
    }

    public static int singleNumber_slow(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result;
        for(int num: nums) {
            if(set.contains(num)) set.remove(num);
            else set.add(num);
        }
        return set.iterator().next();
    }
}