class MyQueueMain {
	public static void main(String args[]) {
		MyQueue_UsingLinkedList que = new MyQueue_UsingLinkedList(3);
		System.out.println(que.enQueue(1)); // return True
		System.out.println(que.enQueue(2)); // return True
		System.out.println(que.enQueue(3)); // return True
		System.out.println(que.enQueue(4)); // return False
		System.out.println(que.Rear());  // return 3
		System.out.println(que.isFull());   // return True
		System.out.println(que.deQueue());  // return True
		System.out.println(que.enQueue(4)); // return True
		System.out.println(que.Rear());     // return 4
	}
}