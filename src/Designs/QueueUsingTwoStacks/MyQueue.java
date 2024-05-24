class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        if(stack2.isEmpty()) {
            stack1.push(x);
        } else {
            transfer(stack2, stack1);
            push(x);
        }
    }
    
    private void transfer(Stack<Integer> s1, Stack<Integer> s2) {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    public int pop() {
        transfer(stack1, stack2);
        return stack2.pop();
    }
    
    public int peek() {
        transfer(stack1, stack2);
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}