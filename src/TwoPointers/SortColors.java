// This is an extentions of move zeros

import java.util.*;

class SortColors {
	public static void main(String args[]) {
		List<int[]> list = new ArrayList<>();
		list.add(new int[]{1,1,0,2});
		list.add(new int[]{1,0,2,2,1,0,0,1});

		for(int[] colors: list) {
			for(int color: sortColors(colors)) System.out.print(color+", ");
			System.out.println();
		}
	}

	public static int[] sortColors (int[] colors) {
		int start=0;
		int curr=0;
		int end=colors.length-1;

		while(curr<=end) {
			if(colors[curr]==0) {
				swap(colors, curr, start);
				curr++;
				start++;
			} else if(colors[curr]==1) {
				curr++;
			} else {
	        	// curr is not incremented in this case.
	        	// because when a element is swapped from the end,
	        	// the swapped element will be skipped from comparison.
				swap(colors, curr, end);
				end--;
			}
		}
		return colors;
	}

	public static void swap(int[] colors, int indexA, int indexB) {
		int temp = colors[indexA];
		colors[indexA]=colors[indexB];
		colors[indexB]=temp;
	}
}