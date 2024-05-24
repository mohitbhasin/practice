import java.util.*;
// this is better becase it has amortized runtime to o(1) for all the operations
class MyQueue_Better {
	Stack<Integer> s1;
	Stack<Integer> s2;

    public MyQueue_Better() {
        s1 = new Stack<>();
		s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(s2.isEmpty()) moveToS2();
        return s2.pop();
    }
    
    public int peek() {
        if(s2.isEmpty()) moveToS2();
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    private void moveToS2() {
    	while(!s1.isEmpty()) {
    		s2.push(s1.pop());
    	}
    }
}