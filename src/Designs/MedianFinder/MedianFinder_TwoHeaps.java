import java.util.*;

class MedianFinder_TwoHeaps{
	PriorityQueue<Integer> lo;
    PriorityQueue<Integer> hi;
    public MedianFinder_TwoHeaps() {
        // below definition for reverse can be used as well
        // lo = new PriorityQueue<>((a,b) -> (int) b - (int) a);
        lo = new PriorityQueue<>(Comparator.reverseOrder());
        hi = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        lo.offer(num);
        hi.offer(lo.poll());

        if(hi.size()>lo.size()) {
            lo.offer(hi.poll());
        }       
    }
    
    public double findMedian() {
        return lo.size()>hi.size() ? lo.peek() : ((double) hi.peek() + (double) lo.peek())/2;
    }
}