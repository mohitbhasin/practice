import java.util.*;

class ValidateSkipListLinear {
	public static void main(String args[]) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		ListNode[] arr = {new ListNode(1), new ListNode(2), new ListNode(3), new ListNode(4), new ListNode(5)};
		arr[0].next = arr[1];
		arr[1].next = arr[2];
		arr[2].next = arr[3];
		arr[3].next = arr[4];

		// Default case
		// Expected output: true
		//  _________      ____    
		// |         ↓    |    ↓
		// 1 -> 2 -> 3 -> 4 -> 5 -> X
		//      ↓    ↓         ↓
		//      X    X         X
		arr[0].skip = arr[2];
		arr[3].skip = arr[4];
		System.out.println("Case 0: "+validate(arr[0]));
		
		// case 1: list break after 4
		// Expected output: false
		arr[3].next = null;
		System.out.println("Case 1: "+validate(arr[0]));
		arr[3].next = arr[4];

		// case 2: 3 skips to 2
		// Expected output: false
		arr[2].skip = arr[1];
		System.out.println("Case 2: "+validate(arr[0]));
		arr[2].skip=null;

		// case 3: 3 skips to 4
		// Expected output: true
		arr[2].skip = arr[3];
		System.out.println("Case 3: "+validate(arr[0]));
		arr[2].skip=null;

		// case 4: 3 skips to 5
		// Expected output: true
		arr[2].skip = arr[4];
		System.out.println("Case 4: "+validate(arr[0]));
		arr[2].skip=null;

		// case 5: 3 skips to 3
		// Expected output: false
		arr[2].skip = arr[2];
		System.out.println("Case 5: "+validate(arr[0]));
		arr[2].skip=null;

		// case 6: 5 skips to 1
		// Expected output: false
		arr[4].skip = arr[0];
		System.out.println("Case 6: "+validate(arr[0]));
		arr[4].skip=null;

		// case 7: 3 skips to 1
		// Expected output: false
		arr[2].skip = arr[0];
		System.out.println("Case 7: "+validate(arr[0]));
		arr[2].skip=null;

		// case 8: break after 2 and break after 4
		// Expected output: false
		arr[1].next = null;
		arr[3].next = null;
		System.out.println("Case 8: "+validate(arr[0]));
		arr[1].next = arr[2];
		arr[3].next = arr[4];
	}

	public static boolean validate(ListNode head) {
		//check count
		int count = 0;
		ListNode curr = head;
		while(curr!=null) {
			count++;
			curr=curr.next;
		}

		Set<ListNode> set = new HashSet<>();
		curr = head;
		while(curr!=null) {
			set.add(curr);
			if(curr.skip==curr) return false;
			if(curr.skip!=null) set.add(curr.skip);
			curr=curr.next;
		}
		if(count!=set.size()) return false;
		return checkCycleLinear(head);
	}

	public static boolean checkCycleLinear(ListNode curr) {
		Set<ListNode> set = new HashSet<>();
		while(curr!=null) {
			if(set.contains(curr.skip)) {
				return false;
			}
			set.add(curr);
			curr=curr.next;
		}
		return true;
	}

}

class ListNode {
	int val;
	ListNode next;
	ListNode skip;
	public ListNode(int val) {
		this.val = val;
		this.next = null;
		this.skip = null;
	}
	public String toString() {
		return ""+val;
	}
}