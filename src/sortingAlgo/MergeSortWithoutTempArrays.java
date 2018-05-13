package sortingAlgo;

public class MergeSortWithoutTempArrays {
	public static void main(String args[]) {
		int[] data = {12, 1, 13, 5, 4, 7,0,3,4};
		//not working for below array with "1" at that place. works fine is changed to
		//number greater than 1;
//		int[] data = {3,1,5,8,2,4,7};
		int right = data.length-1;
		for(int a : data) {
			System.out.print(a+",");
		}
		System.out.println("\nAfter Merge sort");
		for(int a : mergeSort(data,0,right)) {
			System.out.print(a+",");
		}
	}
	
	public static int[] mergeSort(int[] data, int left, int right) {
		int mid = (left + right) / 2;
		if(left == mid) {
			return null;
		} else {
			mergeSort(data,left, mid);
			mergeSort(data,mid,right);
			merge(data, left, right, mid);
		}
		return data;
	}
	
	private static void merge(int[] data, int left, int right, int mid) {
		for(int i=0; i<=mid; i++) {
			for(int j=mid+1; j<=right;j++) {
				if(data[i]>data[j]) {
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
	}
}
