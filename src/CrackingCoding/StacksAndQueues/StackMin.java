import java.util.Stack;

class StackMin {
	static Stack<Integer> stack = new Stack<Integer>();
	static Stack<Integer> minStack = new Stack<Integer>();

	public static void main(String args[]) {
		int[] nums = {4,3,6,8,1,9};
		push(4);
		System.out.println(getMin());
		push(3);
		System.out.println(getMin());
		push(6);
		pop();
		System.out.println(getMin());
		push(8);
		push(1);
		System.out.println(getMin());
		push(9);
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(getMin());
	}

	public static void push(int num) {
		stack.push(num);

		if(minStack.isEmpty() || minStack.peek() > num) {
			minStack.push(num);
		}
	}

	public static int pop() {
		if(stack.peek()  == minStack.peek()) {
			minStack.pop();
		}

		return stack.pop();
	}

	public static int getMin() {
		return minStack.peek();
	}

}