import java.util.*;

class ReorderList {
	public static void main(String args[]) {
		ListNode head = new ListNode(1);
		head.add(2);
		head.add(3);
		head.add(4);
		head.add(5);
		head.add(6);
		reorder(head); //Iterative. better because has O(1) space complexity.
		// reorderList_array(head);
		// reorderList_recursion(head);
		while(head!=null) {
			System.out.print(head.val + "-->");
			head=head.next;
		}
	}

	public static void reorder(ListNode head) {
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


		// Merge the two halves
		ListNode l1 = head;
		ListNode l2 = prev;

		// while(l1!=null && l2!=null) {
		// 	ListNode temp1 = l1.next;
		// 	ListNode temp2 = l2.next;

		// 	l1.next = l2;
		// 	l2.next = temp1;
		// 	l2 = temp2;
		// 	l1 = temp1;
		// }

		while(l2.next!=null) {
			ListNode temp = l1.next;
			l1.next = l2;
			l2=l2.next;
			l1.next.next=temp;
			l1 = temp;		
		}

		// while(l1!=null) {
		// 	System.out.print(l1.val+"-> ");
		// 	l1=l1.next;
		// }
		// System.out.println();
		// while(l2!=null) {
		// 	System.out.print(l2.val+"-> ");
		// 	l2=l2.next;
		// }

		// while(l2.next!=null) {
		// 	ListNode temp = l1.next;
		// 	l1.next = l2;
		// 	l1=temp;

		// 	temp = l2.next;
		// 	l2.next = l1;
		// 	l2=temp;		
		// }
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