class MyQueue_Better_Main {
	public static void main(String args[]) {
		MyQueue_Better myQueue = new MyQueue_Better();
		myQueue.push(1); // queue is: [1]
		myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
		System.out.println(myQueue.peek()); // return 1
		System.out.println(myQueue.pop()); // return 1, queue is [2]
		System.out.println(myQueue.empty()); // return false
	}
}