import java.util.*;

// Median is mid value of ordered set. if number of values are even then median is average of the two middle values.
// 1. Using ArrayList and sorting it using Collections.sort() is slow. for every time findMedian is called, sort will be called
// 2. Using PriorityQueue with arraylist is slow too. Median is calculated by copying pques values in arrayList so it is sorted abd then finding median value.
// 3. Using Insertion sort keeps the new coming elements sorted in O(logN) + O(n) for shifting elements (?? not sure about this in java). findMedian() will take middle elements from sorted list at O(1).
// 4. Two Heaps another efficient apprach. use two priorityQueues. use one to store half small elements in reverse and another half to store larger elements in ascending. 
class MedianFinder {
    public static void main(String args[]) {
        MedianFinder_TwoHeaps obj = new MedianFinder_TwoHeaps();
        obj.addNum(-1);
        obj.addNum(-2);
        obj.addNum(-3);
        obj.addNum(-4);
        obj.addNum(-5);
        System.out.println(obj.findMedian());

        MedianFinder_InsertionSort obj2 = new MedianFinder_InsertionSort();
        obj2.addNum(1);
        obj2.addNum(2);
        obj2.addNum(3);
        System.out.println(obj2.findMedian());

    }
}