import java.util.*;

class MinStack_TwoStacks {
    Stack<Integer> stack;
    Stack<Integer> minTracker;

    public MinStack_TwoStacks() {
        stack = new Stack<>();
        minTracker = new Stack();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minTracker.isEmpty()) {
            minTracker.push(val);
        } else {
            if(val<=minTracker.peek()) {
                minTracker.push(val);
            }
        }
    }
    
    public void pop() {
        if(stack.pop().equals(minTracker.peek())) {
            minTracker.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minTracker.peek();
    }
}