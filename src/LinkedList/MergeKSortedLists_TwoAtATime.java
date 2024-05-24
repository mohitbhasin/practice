import java.util.*;

class MergeKSortedLists_TwoAtATime {
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
}