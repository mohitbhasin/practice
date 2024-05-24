import java.util.*;

class SortList {
	public static void main(String args[]) {
		ListNode head = new ListNode(10);
		head.add(1);
		head.add(60);
		head.add(30);
		head.add(5);
		head.printList();
		ListNode result = mergeSort(head);
		// using PriorityQueue
		// ListNode result = sortList(head);
		result.printList();
	}

	public static ListNode mergeSort(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode mid = breakAtMid(head);
		ListNode left = mergeSort(head);
		ListNode right = mergeSort(mid);

		return merge(left, right);
	}

	public static ListNode breakAtMid(ListNode head) {
		ListNode slow = null;
		ListNode fast = head;

		while(fast!=null && fast.next!=null) {
			slow = slow==null ? head : slow.next;
			fast = fast.next.next;
		}

		ListNode mid = slow.next;
		slow.next = null;

		return mid;
	}

	public static ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		while(left!=null && right!=null) {
			if(left.val<right.val) {
				curr.next = left;
				left=left.next;
			} else {
				curr.next = right;
				right=right.next;
			}
			curr = curr.next;
		}

		if(left!=null) {
			curr.next = left;
		} else {
			curr.next = right;
		}

		return dummy.next;
	}
	// using priorityQueue
	public static ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        ListNode curr = head;
        while(curr!=null) {
            pq.offer(curr);
            curr=curr.next;
        }

        head = pq.poll();
        curr = head;
        while(!pq.isEmpty()) {
            curr.next = pq.poll();
            curr=curr.next;
        }
        if(curr!=null) curr.next = null;
        return head;
    }
}