import java.util.*;

class LRUCacheDoubly {
	int size;
    DListNode head;
    DListNode tail;
    int capacity;
    Map<Integer, DListNode> cache;

    public static void main(String args[]) {
    	LRUCacheDoubly lru = new LRUCacheDoubly(2); 
    	// lru.put(1, 1);
        // lru.put(2, 2);
        // System.out.println(lru.get(1));
        // lru.put(3, 3);
        // System.out.println(lru.get(2));
        // lru.put(4, 4);
        // System.out.println(lru.get(1));
        // System.out.println(lru.get(3));
        // System.out.println(lru.get(4));

        lru.put(1, 0);
        lru.put(2, 2);
        System.out.println(lru.get(1));
        lru.put(3, 3);
        System.out.println(lru.get(2));
        lru.put(4, 4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));

        // lru.put(2, 1);
        // lru.put(1, 1);
        // lru.put(2, 3);
        // lru.put(4, 1);
        // System.out.println(lru.get(1));
        // System.out.println(lru.get(2));
    }

    public LRUCacheDoubly(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new DListNode();
        this.tail = new DListNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.cache = new HashMap<>();
    }
    
    public int get(int key) {
    	if(!cache.containsKey(key)) return -1;
    	DListNode curr = cache.get(key);
    	removeNode(curr);
    	addNode(curr);
    	return curr.val;
    }
 	// if present, remove from location and add at the end (move to end(removeNode+addNode))
 	// if not present, create and add at the end (addNode)
    public void put(int key, int value) {
    	DListNode curr;
        if(!cache.containsKey(key)) {
        	curr = new DListNode();
        	curr.key = key;
    		curr.val = value;
    		cache.put(key, curr);
    		// discard head node
    		if(size==capacity) {
        		cache.remove(head.next.key);
        		removeNode(head.next);
        		size--;
        	}
        	size++;
        } else {
        	curr = cache.get(key);
        	curr.val = value;
        	removeNode(curr);
        }
		addNode(curr);
    }

    // add the node to the tail
    public void addNode(DListNode node) {
    	node.prev = tail.prev;
    	tail.prev.next = node;
    	node.next = tail;
    	tail.prev = node;
    }
    // remove from its location
    public void removeNode(DListNode node) {
    	node.prev.next = node.next;
    	node.next.prev = node.prev;
    }
    
    class DListNode {
    	int key;
        int val;
        DListNode prev;
        DListNode next;
    }
}