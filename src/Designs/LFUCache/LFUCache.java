import java.util.*;

// Incorrect
class LFUCache {
	HashMap<Integer, Node> cache;
	PriorityQueue<Node> que;
	int capacity;
	int size;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.cache = new HashMap<Integer, Node>();
        this.que = new PriorityQueue<Node>((a,b) -> a.count - b.count);
        // this.que = new PriorityQueue<Node>(new Comparator<Node>() {
        // 	@Override
        //     public int compare(Node a, Node b) {
        // 		return a.count - b.count;
        // 	}
        // });
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
        	Node node = cache.get(key);
        	node.count++;
        	return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node;
        if(!cache.containsKey(key)) {
            size++;
            // System.out.println(key+"->"+que);
            if(size>capacity) {
                node = que.poll();
                // System.out.println("polled="+node.key);
                cache.remove(node.key);
                size--;
            }
        	node = new Node(key, value);
        	cache.put(key, node);
            que.add(node);
        } else {
        	node = cache.get(key);
        	node.count++;
        }
    }
}


class Node {
	int key;
	int value;
	int count;

	Node(int key, int value) {
		this.key = key;
		this.value = value;
		this.count = 1;
	}

    public String toString() {
        return "["+key+":"+value+" c:"+count+"]";
    }
}