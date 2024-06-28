class HeapMain {
	public static void main(String args[]) {
		Heap heap = new Heap(18);

		heap.offer(2);
		heap.offer(4);
		heap.offer(8);
		heap.offer(9);
		heap.offer(7);
		heap.offer(10);
		heap.offer(9);
		heap.offer(15);
		heap.offer(20);
		heap.offer(13);
		heap.offer(9);
		heap.offer(14);
		heap.offer(20);
		heap.offer(11);
		heap.offer(19);
		heap.offer(20);
		heap.offer(17);
		heap.offer(3);
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
	}
}