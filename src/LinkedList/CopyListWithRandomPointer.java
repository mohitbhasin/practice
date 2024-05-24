import java.util.*;

class CopyListWithRandomPointer {
	public static void main(String args[]) {
		Node head = new Node(7);
		head.next = new Node(13);
		head.next.next = new Node(11);
		head.next.next.next = new Node(10);
		head.next.next.next.next = new Node(1);		
		head.next.random = head;
		head.next.next.random = head.next.next.next.next;
		head.next.next.next.random = head.next.next;
		head.next.next.next.next.random = head;

		Node copy = copyRandomList(head);
		// Node copy = copyRandomList_old(head);
		while(copy!=null) {
			Integer rand_val = copy.random == null ? null : copy.random.val;
			System.out.print(copy.val+"[" + rand_val+"] --> ");
			copy=copy.next;
		}
	}

	public static Node copyRandomList(Node head) {
        if(head==null) return null;
        Map<Node, Node> map = new HashMap<>();
        
        Node curr = head;
        while(curr!=null) {
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            curr=curr.next;
        }
        
        curr = head;
        
        while(curr!=null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }
        
        return map.get(head);
    }

	 public static Node copyRandomList_old(Node head) {
        if(head==null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        map.put(head, new Node(head.val));
        Node copy = map.get(curr);
        while(curr.next!=null) {
            curr=curr.next;
            copy.next = new Node(curr.val);
            copy=copy.next;
            map.put(curr, copy);
        }
        
        for(Node key: map.keySet()) {
            copy = map.get(key);
            copy.random = map.get(key.random);
        }
        
        return map.get(head);
    }
}

class Node {
	int val;
	Node next;
	Node random;

	Node(int val) {
		this.val = val;
	}
}