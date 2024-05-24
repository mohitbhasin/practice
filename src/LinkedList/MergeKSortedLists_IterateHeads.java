import java.util.*;

class MergeKSortedLists_IterateHeads {
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