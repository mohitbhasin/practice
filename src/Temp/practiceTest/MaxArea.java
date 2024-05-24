import java.util.*;

class MaxArea {
	public static void main(String args[]) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(findMaxArea(height));
	}

	public static int findMaxArea(int[] height) {
		int maxArea = (int) Math.pow(Math.min(height[0], height[1]), 2);
		int[] maxIndex = {0,1};

		for(int i=2; i<height.length; i++) {
			int a = (int) Math.pow(Math.min(maxIndex[0], height[i]), 2);
			int b = (int) Math.pow(Math.min(maxIndex[1], height[i]), 2);

			maxArea = Math.max(Math.max(a, b), maxArea);
		}
		return maxArea;
	}
}