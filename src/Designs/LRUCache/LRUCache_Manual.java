import java.util.*;

class LRUCache_Manual {
    Map<Integer, DListNode> cache;
    int capacity;
    int size;
    DListNode head;
    DListNode tail;

    //Cases:
    //add to head, move to head, update existing, remove when meets capacity
    
    public LRUCache_Manual(int capacity) {
        this.capacity=capacity;
        this.cache=new HashMap<>();
        this.head=new DListNode();
        this.tail=new DListNode();
        size=0;
        head.next=tail;
        tail.prev=head;
    }
//  adding node
    public void addNode(DListNode node) {
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
//  removing node
    public void removeNode(DListNode node) {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
//  cases for get operation   
    public void moveToHead(DListNode node) {
        removeNode(node);
        addNode(node);
    }
//  cases where capacity is met
    public DListNode removeTail() {
        DListNode pre = tail.prev;
        removeNode(pre);
        return pre;
    }
    
    public int get(int key) {
        DListNode curr = cache.get(key);
        if(curr==null) return -1;
        moveToHead(curr);
        return curr.val;
    }
    
    public void put(int key, int value) {
        DListNode curr = cache.get(key);
        if(curr==null) {
            curr=new DListNode();
            curr.key=key;
            curr.val=value;
            addNode(curr);
            cache.put(key, curr);
            size++;
            if(size>capacity) {
                DListNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            curr.val=value;
            moveToHead(curr);
        }
    }
    
    class DListNode {
        int key;
        int val;
        DListNode next;
        DListNode prev;
    }
}