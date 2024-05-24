import java.util.*;

class MinStack_withOneStack {
    //set object for val and min
    //based on top min, curr
    class Pair {
        int val;
        int min;
        public Pair(int val, int min) {
            this.val=val;
            this.min=min;
        }
    }
    Stack<Pair> stack;
    public MinStack_withOneStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        Pair pair;
        if(stack.isEmpty()) {
            pair = new Pair(val, val);
        } else {
            pair = new Pair(val, Math.min(stack.peek().min, val));
        }
        stack.push(pair);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}