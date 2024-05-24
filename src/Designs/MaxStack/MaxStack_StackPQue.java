import java.util.*;

class MaxStack_StackPQue {
    Stack<int[]> stack;
    Queue<int[]> pq;
    Set<Integer> trackerSet;
    int index;

    public MaxStack_StackPQue() {
        stack = new Stack();
        pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0]==b[0]) return b[1]-a[1];
                return b[0] - a[0];
            }
        });
        trackerSet = new HashSet<>();
        index=0;
    }
    
    public void push(int x) {
        stack.push(new int[]{x, index});
        pq.offer(new int[]{x, index});
        index++;
    }
    
    public int pop() {
        // discard top elements of stack if thier indexes are in tracker set;
        while(trackerSet.contains(stack.peek()[1])) {
            stack.pop();
        }
        int[] temp = stack.pop();
        trackerSet.add(temp[1]);
        return temp[0];
    }
    
    public int top() {
        // discard top elements of stack if their indexes are in tracker set;
        while(trackerSet.contains(stack.peek()[1])) {
            stack.pop();
        }
        return stack.peek()[0];
    }
    
    public int peekMax() {
        // discard top elements of priority queue if their indexes are in tracker set;
        while(trackerSet.contains(pq.peek()[1])) {
            pq.poll();
        }
        return pq.peek()[0];
    }
    
    public int popMax() {
        // discard top elements of priority queue if their indexes are in tracker set;
        while(trackerSet.contains(pq.peek()[1])) {
            pq.poll();
        }
        int[] temp = pq.poll();
        trackerSet.add(temp[1]);
        return temp[0];
    }
}