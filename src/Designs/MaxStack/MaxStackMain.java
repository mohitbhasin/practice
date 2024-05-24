import java.util.*;

class MaxStackMain {
	public static void main(String args[]) {
		MaxStack_TreeSet maxStack = new MaxStack_TreeSet();
		// MaxStack_StackPQue maxStack = new MaxStack_StackPQue();
		maxStack.push(92);
		System.out.println(maxStack.peekMax());
		maxStack.push(54);
		System.out.println(maxStack.peekMax());
		maxStack.push(22);
		System.out.println(maxStack.pop());
		System.out.println(maxStack.pop());
		maxStack.push(-57);
		System.out.println(maxStack.peekMax());
		maxStack.push(-24);
		System.out.println(maxStack.popMax());
		System.out.println(maxStack.top());
		maxStack.push(26);
		maxStack.push(-71);
		System.out.println(maxStack.peekMax());
		System.out.println(maxStack.popMax());
		System.out.println(maxStack.popMax());
	}
}