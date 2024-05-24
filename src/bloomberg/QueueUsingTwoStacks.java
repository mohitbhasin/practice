import java.util.*;

class QueueUsingTwoStacks {
	static Stack<Integer> s1 = new Stack<>();
	static Stack<Integer> s2 = new Stack<>();
	public static void main(String args[]) {
		enqueue(42);
		dequeue();
		enqueue(14);
		printTop();
		enqueue(28);
		printTop();
		enqueue(60);
		enqueue(78);
		dequeue();
		dequeue();
		printTop();
	}

	public static void enqueue(int val) {
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		s2.push(val);

		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}

	public static int dequeue() {
		return !s1.isEmpty() ? s1.pop() : Integer.MIN_VALUE;
	}

	public static void printTop() {
		if(!s1.isEmpty()) {
			System.out.println(s1.peek());
		} else {
			System.out.println("Empty");
		}
	}
}