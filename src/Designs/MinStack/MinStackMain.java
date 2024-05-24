class MinStackMain {
	public static void main(String args[]) {
		MinStack_TwoStacks stack = new MinStack_TwoStacks();
		stack.push(512);
		stack.push(-1024);
		stack.push(-1024);
		stack.push(512);
		System.out.println("---->"+stack.minTracker);
		stack.pop();
		System.out.println(stack.getMin());
		System.out.println("---->"+stack.minTracker);
		stack.pop();
		System.out.println(stack.getMin());
		System.out.println("---->"+stack.minTracker);
		stack.pop();
		System.out.println(stack.getMin());
		System.out.println("---->"+stack.minTracker);
	}
}