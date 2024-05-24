import java.util.*;



class TopKFrequentElements {
    public static void main(String args[]) {
        // int[] nums = {1,1,1,2,2,3};
        // int k = 2;

        int[] nums = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        int k = 10;

        int[] result = topKFrequent(nums, k);
        for(int r: result) {
            System.out.print(r+", ");
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
            if(!map.containsKey(n)) {
                map.put(n,1);
            } else {
                map.put(n, map.get(n)+1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));

        for(int key: map.keySet()) {
            pq.offer(key);
            if(pq.size()>k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for(int i=0; i<k; i++) {
            result[i]=pq.poll();
        }
        return result;
    }

    // Not better than using priority queue. Time Complexity for this is O(n log n);
    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            if(!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num)+1);
            }
        }

        List<Integer> sortedList = new LinkedList<>();
        

        for(int key: map.keySet()) {
            int index = 0;
            while(index<k) {
                if(index<sortedList.size()) {
                    if(map.get(sortedList.get(index))<map.get(key)) {
                        sortedList.add(index, key);
                        break;
                    } else {
                        index++;
                    }
                } else {
                    sortedList.add(index, key);
                    break;
                }
            }
        }
        int[] result = new int[k];
        for(int i=0; i<k; i++) {
            result[i] = sortedList.get(i);
        }
        return result;
    }
}