import java.util.*;

class ConvertSortedListToBinarySearchTree {
	public static void main(String args[]) {
		// [-10,-3,0,5,9]
		ListNode head = new ListNode(-10);
		head.next = new ListNode(-3);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(9);

		TreeNode root = sortedListToBST(head);
		System.out.println(root);
	}

	public static TreeNode sortedListToBST(ListNode head) {
        List<Integer> numList = new ArrayList<>();
        while(head!=null) {
            numList.add(head.val);
            head=head.next;
        }

        return createTree(numList, 0, numList.size()-1);
    }

    public static TreeNode createTree(List<Integer> numList, int left, int right) {
        if(left>right) {
            return null;
        }

        int mid = (left+right)/2;
        TreeNode root = new TreeNode(numList.get(mid));
        root.left=createTree(numList, left, mid-1);
        root.right=createTree(numList, mid+1, right);
        return root;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }