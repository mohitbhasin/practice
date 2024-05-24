import java.util.*;

class LastStoneWeight {
    public static void main(String args[]) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
           public int compare(Integer a, Integer b) {
                return b - a;
            } 
        });
        
        for(int stone: stones) {
            pq.offer(stone);
        }
        
        while(pq.size()>1) {
            int a = pq.poll();
            int b = pq.poll();
            
            int diff = Math.abs(a-b);
            if(diff>0) {
                pq.offer(diff);
            }
        }
        
        return pq.size()==0 ? 0 : pq.poll();
    }
}