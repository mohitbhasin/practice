class Heap {
	int[] arr;
	int size;

	Heap(int size) {
		this.arr = new int[size];
		this.size = 0;
	}

	public int peek() {
		if(size==0) throw new IllegalStateException();
		return arr[0];
	}

	public void offer(int val) {
		if(size==arr.length) throw new ArrayIndexOutOfBoundsException();
		int index = size;
		arr[index] = val;
		size++;
		if(size!=1) heapifyUp();
	}

	public int poll() {
		if(size==0) throw new IllegalStateException();
		int val = arr[0];
		arr[0] = arr[size-1];
		size--;
		if(size!=0) heapifyDown();
		return val;
	}

	public void heapifyUp() {
		int index = size-1;
		int parentIndex = getParentIndex(index);
		
		while(parentIndex>=0 && arr[index]<arr[parentIndex]) {
			int temp = arr[index];
			arr[index] = arr[parentIndex];
			arr[parentIndex] = temp;
			index = parentIndex;
			parentIndex = getParentIndex(index);
		}

	}

	public void heapifyDown() {
		int index = 0;
		while(getLeftChildIndex(index)<size) {
			int leftChildIndex = getLeftChildIndex(index);
			int rightChildIndex = getRightChildIndex(index);

			int smallChildIndex = arr[leftChildIndex] < arr[rightChildIndex] ? leftChildIndex : rightChildIndex;

			int parent = arr[index];
			arr[index] = arr[smallChildIndex];
			arr[smallChildIndex] = parent;

			index=smallChildIndex;
		}
	}

	public int getLeftChildIndex(int parentIndex) {
		return parentIndex*2 + 1;
	}

	public int getRightChildIndex(int parentIndex) {
		return parentIndex*2 + 2;
	}

	public int getParentIndex(int childIndex) {
		return (childIndex - 1)/2;
	}
}