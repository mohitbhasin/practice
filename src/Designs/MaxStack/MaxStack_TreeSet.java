import java.util.*;

class MaxStack_TreeSet {
    TreeSet<int[]> stack;
    TreeSet<int[]> values;
    int count;

    public MaxStack_TreeSet() {
        Comparator<int[]> comp = new Comparator<>() {
            public int compare(int[] a, int[] b) {
                if(a[0]==b[0]) {
                    return b[1] - a[1];
                } else {
                    return b[0] - a[0];
                }
            }
        };
        stack = new TreeSet<>(comp);
        values = new TreeSet<>(comp);
        count=0;
    }
    
    public void push(int x) {
        stack.add(new int[] {count, x});
        values.add(new int[] {x, count});
        count++;
    }
    
    public int pop() {
        int[] value = stack.pollFirst();
        values.remove(new int[] {value[1], value[0]});
        return value[1];
    }
    
    public int top() {
        return stack.first()[1];
    }
    
    public int peekMax() {
        return values.first()[0];
    }
    
    public int popMax() {
        int[] value = values.pollFirst();
        stack.remove(new int[] {value[1], value[0]});
        return value[0];
    }
}