public class ZigzagIterator {
    boolean flag;
    List<Integer> currQueue;
    List<Integer> vector1;
    List<Integer> vector2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        vector1 = v1;
        vector2 = v2;
        currQueue = !vector1.isEmpty() ? vector1 : vector2;
        flag=true;        
    }

    public int next() {
       int result = currQueue.remove(0);
       if(flag && !vector2.isEmpty()) {
           currQueue = vector2;
           flag=false;
       }
       else if(!flag && !vector1.isEmpty()) {
           currQueue = vector1;
           flag=true;
       }
       return result;
    }

    public boolean hasNext() {
        return !currQueue.isEmpty();
    }
}