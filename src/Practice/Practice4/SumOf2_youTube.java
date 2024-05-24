import java.util.*;

class SumOf2_youTube {
	public static void main(String args[]) {
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
		int[] b = {10, 20, 30, 40, 50, 60, 70 , 80, 90};
		System.out.println(sum2(a, b, 99, 0, a.length-1, 0, b.length-1));
		System.out.println(sum2Simple(a, b, 45));

	}

	public static boolean sum2(int[] a, int[] b, int val, int aL, int aR, int bL, int bR) {
		if(aL>aR || bL>bR) {
			return false;
		}
		int aMid=(aR+aL)/2;
		int bMid=(bR+bL)/2;
		int sum = a[aMid] + b[bMid];
		if(sum==val) {
			return true;
		}
		if(sum<val) {
			return sum2(a, b, val, aMid+1, aR, bL, bR) || sum2(a, b, val, aL, aR, bMid+1, bR);
		}
		else {
			return sum2(a, b, val, aL, aMid-1, bL, bR) || sum2(a, b, val, aL, aR, bL, bMid-1);
		}
	}

	public static boolean sum2Simple(int[] a, int[] b, int val) {
		Set<Integer> set = new HashSet<Integer>();
		for(int num: a) {
			set.add(val-num);
		}
		for(int num: b) {
			if(set.contains(num)) {
				return true;
			}
		}
		return false;
	}
}