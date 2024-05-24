import java.util.*;

class MedianFinder_InsertionSort{
	List<Integer> stream;
    public MedianFinder_InsertionSort() {
        stream = new ArrayList<Integer>();
    }
    
    public void addNum(int num) {
        if(stream.size()==0) {
            stream.add(num);
            return;
        }
        int left = 0;
        int right = stream.size()-1;
        int mid=0;
        while(left<=right) {
            mid = (left + right)/2;
            if(num>stream.get(mid)) {
                left=mid+1;
            } else {
                right=mid-1;
            }
        }
        if(num>stream.get(mid)) {
            this.stream.add(mid+1, num);
        } else {
            this.stream.add(mid, num);
        }
    }
    
    public double findMedian() {
        double result;
        int index = stream.size()/2;
        if(stream.size()%2==0) {            
            result = ((double) stream.get(index)+ (double) stream.get(index-1))/2;
        } else {
            result = stream.get(index);
        }
        return result;
    }
}