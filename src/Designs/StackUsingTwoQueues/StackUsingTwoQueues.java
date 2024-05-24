import java.util.*;

class StackUsingTwoQueues {
	Queue<Integer> q1;
    Queue<Integer> q2;
    int top;

    public StackUsingTwoQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        top = -1;
    }
    
    public void push(int x) {
        q1.offer(x);
        top = (x);
    }
    
    public int pop() {
        while(q1.size()>1) {
        	top = q1.poll();
            q2.offer(top);
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return q2.poll();
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}