// import java.util.*;

class ContainerWithMostWater {
	public static void main(String args[]) {
		// int[] height = {1,8,6,2,5,4,8,3,7};
		int[] height = {2,3,4,5,18,17,6};
		// int[] height = {4,3,2,1,4};
		// int[] height = {1,1};
		// int[] height = {1,2,1};
		// System.out.println(maxArea(height));
		System.out.println(maxArea2(height));
		System.out.println("---------");
		System.out.println(maxArea3(height));
	}

	public static int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int max = 0;

        while(left<right) {
            int len = right - left;
            int breadth = Math.min(height[left], height[right]);
            int area = len*breadth;
            System.out.println(area);
            max=Math.max(max, area);
            if(height[left]<height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

	//O(n2)
	public static int maxArea1(int[] height) {
		int max=Integer.MIN_VALUE;
		for(int i=0; i<height.length-1; i++) {
			for(int j=1; j<height.length; j++) {
				max=Math.max(max, area(height, i, j));
			}
		}
		return max;
	}

	public static int area(int[] height, int i, int j) {
		int length = j-i;
		int breadth = Math.min(height[i], height[j]);
		return length*breadth;
	}

	public static int maxArea2(int[] height) {
		int start = 0;
		int end = height.length-1;

		int maxArea=Integer.MIN_VALUE;

		while(start<end) {
			int minHeight = Math.min(height[start], height[end]);
			maxArea = Math.max(maxArea, minHeight*(end-start));
			System.out.println(maxArea+" - "+height[start] + ", " +height[end]);
			if(height[start]>height[end]) {
				end--;
			} else {
				start++;
			}
		}

		return maxArea;
	}

	public static int maxArea3(int[] height) {
        int max = Integer.MIN_VALUE;
        int begin = 0;
        int end = height.length-1;
        while(begin<end) {
            int h = Math.min(height[begin], height[end]) * Math.abs(begin-end);
            max=Math.max(max, h);
            System.out.println(max+" - "+begin + ", " +end);
            if(begin>end) {
                end--;
            } else {
                begin++;
            }
        }
        return max;
    }
}
