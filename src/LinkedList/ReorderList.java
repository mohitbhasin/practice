import java.util.*;

class ReorderList {
	public static void main(String args[]) {
		ListNode head = new ListNode(1);
		head.add(2);
		head.add(3);
		head.add(4);
		head.add(5);
		// head.add(6);
		head.printList();
		reorder_constant_space(head); //Iterative. better because has O(1) space complexity.
		// reorderList_array(head);
		// reorderList_recursion(head);
		while(head!=null) {
			System.out.print(head.val + "-->");
			head=head.next;
		}
	}

	public static void reorder_constant_space(ListNode head) {
		// find middle
		ListNode fast = head;
		ListNode slow = head;

		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
		}


		// reverse second half
		ListNode prev = null;
		ListNode curr = slow;
		while(curr!=null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		prev.printList();
		head.printList();

		// Merge the two halves
		ListNode l1 = head;
		ListNode l2 = prev;

		while(l2.next!=null) {
			ListNode temp = l1.next;
			l1.next = l2;
			l2=l2.next;
			l1.next.next=temp;
			l1 = temp;		
		}
	}

	public static void reorderList_array(ListNode head) {
		List<ListNode> list = new ArrayList<>();
		ListNode curr = head;
		while(curr!=null) {
			list.add(curr);
			curr=curr.next;
		}

		int left = 0;
		int right = list.size() - 1;
		while(left<right) {
			ListNode node_r = list.get(right);
			ListNode node_l = list.get(left);

			node_r.next = node_l.next;
			node_l.next = node_r;
			left++;
			right--;
		}
		list.get(left).next=null;
	}

	static ListNode prev;
    public static void reorderList_recursion(ListNode head) {
        prev=head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        recur(slow);
        slow.next=null;
    }

    public static void recur(ListNode curr) {
        if(curr==null) return;
        recur(curr.next);
        ListNode temp = prev.next;
        prev.next = curr;
        curr.next = temp;
        prev = temp;
    }
}