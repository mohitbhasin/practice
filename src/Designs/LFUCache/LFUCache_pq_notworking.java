import java.util.*;

class LFUCache {
    TreeMap<Integer, Node> map;
    PriorityQueue<Node> pq;
    int size;
    int capacity;
    
    public LFUCache(int capacity) {    
        this.map = new TreeMap<>();
        this.capacity = capacity;
        this.size = 0;
        this.pq = new PriorityQueue<>((a, b) -> {
            return map.get(a.key).freq - map.get(b.key).freq;
        });
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node curr = map.get(key);
        curr.freq++;
        return curr.val;
    }
    
    public void put(int key, int value) {
        Node curr;
        if(map.containsKey(key)) {
            curr = map.get(key);
            curr.val = value;
            curr.freq++;
        } else {
            if(size==capacity) {
                curr = pq.poll();
                map.remove(curr.key);
                size--;
            }
            curr = new Node(key, value);
            map.put(key, curr);
            pq.offer(curr);
            size++;
        }
    }
    
    class Node {
        int key;
        int val;
        int freq;
        Node(int key, int value) {
            this.key = key;
            this.val = value;
            this.freq = 1;
        }
    }
}