import java.util.*;

class MergeKSortedLists_PriorityQueue {
	public static void main(String args[]) {
		ListNode h1 = new ListNode(1);
		h1.add(3);
		h1.add(5);
		h1.add(6);

		ListNode h2 = new ListNode(1);
		h2.add(2);
		h2.add(4);

		ListNode h3 = new ListNode(3);
		h3.add(4);
		h3.add(7);
		h3.add(8);

		ListNode h4 = new ListNode(2);
		h4.add(3);
		h4.add(5);

		int k = 4;

		ListNode[] lists = {h1, h2, h3, h4};

		ListNode result = mergeKLists(lists);
		result.printList();
	}

	public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for(ListNode node: lists) {
            if(node!=null) pq.offer(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if(node.next!=null) pq.offer(node.next);
        }
        return dummy.next;

    }
}