class StackUsingTwoQueues_main {
	public static void main(String args[]) {
		StackUsingTwoQueues myStack = new StackUsingTwoQueues();
		myStack.push(1);
		myStack.push(2);
		System.out.println(myStack.pop()); // return 2
		System.out.println(myStack.top()); // return 2
		System.out.println(myStack.empty()); // return False

	}
}