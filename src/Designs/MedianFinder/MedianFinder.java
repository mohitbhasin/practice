import java.util.*;

class MedianFinder{
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if(maxHeap.size()<minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }       
    }
    
    public double findMedian() {
        return maxHeap.size()>minHeap.size() ? maxHeap.peek() : ((double) minHeap.peek() + (double) maxHeap.peek())/2;
    }
}