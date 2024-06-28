class SearchInSortedArrayOfUnknownSize {
	public static void main(String args[]) {
		int[] arr = {-1,0,3,5,9,12};
		ArrayReader reader = new ArrayReader(arr);

		System.out.println(search(reader, 9));
	}

	// Instead of taking right boundary from max size from constrain,
	// identify it by starting right from 1 and moving it further
	// till value at right becomes greater than target.
	public static int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        
        while(reader.get(right)<target) {
            left=right;
            right*=2;
        }
        return binarySearch(reader, target, left, right);
    }
    
    public static int binarySearch(ArrayReader reader, int target, int left, int right) {
        while(left<=right) {
            int mid = left + (right - left)/2;
            int read = reader.get(mid);
            if(read!=Integer.MAX_VALUE) {
                if(read==target) return mid;
                else if(read>target) right=mid-1;
                else left=mid+1;
            } else {
                right=mid-1;
            }
        }
        return -1;
    }
}

class ArrayReader {
	int[] arr;

	ArrayReader(int[] arr) {
		this.arr = arr;
	}

	public int get(int index) {
		if(index>=this.arr.length) return Integer.MAX_VALUE;
		else return arr[index];
	}
}