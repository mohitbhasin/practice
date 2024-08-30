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

		ListNode result = mergeKLists_pq(lists);
		result.printList();
		// ListNode result = mergeKLists_twoAtATine(lists);
		// result.printList();
		// ListNode result = mergeKLists_iterateHeads(lists);
		// result.printList();
	}
	// faster: O(NlogK)
	public static ListNode mergeKLists_pq(ListNode[] lists) {
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

    // O(NK)
    public static ListNode mergeKLists_twoAtATine(ListNode[] lists) {
        if(lists.length==0) return null;
        ListNode result = lists[0];
        for(int i=1; i<lists.length; i++) {
            result = merge(result, lists[i]);
        }
        return result;
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(l1!=null && l2!=null) {
            if(l1.val<l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if(l1!=null) curr.next = l1;
        else curr.next = l2;

        return dummy.next;
    }

    public static ListNode mergeKLists_iterateHeads(ListNode[] lists) {
         ListNode dummy = new ListNode(0);

        ListNode curr = dummy;

        int minIndex = 0;
        while(minIndex!=-1) {
            int minVal = Integer.MAX_VALUE;
            minIndex=-1;
            for(int i=0; i<lists.length; i++) {
                if(lists[i]!=null && lists[i].val<minVal) {
                    minIndex=i;
                    minVal=lists[i].val;
                }
            }
            if(minIndex==-1) continue;
            curr.next = lists[minIndex];
            curr=curr.next;
            if(lists[minIndex]!=null) lists[minIndex] = lists[minIndex].next;
        }
        return dummy.next;
    }
}