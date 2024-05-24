import java.util.*;

class PalindromeLinkedList {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.add(2);
		head.add(3);
		head.add(4);
		head.add(1);

		// System.out.println(palindrome(head));
		System.out.println(palindrome_recur(head));
		System.out.println(palindrome_reveseSecondHalf(head));
	}
	// ------------------------
	//Better O(1) space. reverse send half in-place and compare. better to reverse it back to original(not done here).
	public static boolean palindrome_reveseSecondHalf(Node head) {
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
		}

		Node half_rev = reverse(slow);
		Node curr = head;
		while(curr!=null && half_rev!=null) {
			if(curr.val!=half_rev.val) return false;
			curr=curr.next;
			half_rev=half_rev.next;
		}
		return true;
	}

	public static Node reverse(Node curr) {
		Node prev=null;
		while(curr!=null) {
			Node next = curr.next;
			curr.next=prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	//--------------------------
	//Recursion advance. still O(n)
	static Node front_pointer;
	public static boolean palindrome_recur(Node head) {
		front_pointer = head;
		return recur_helper(head);
	}
	public static boolean recur_helper(Node curr) {
		if(curr!=null) {
			if(!recur_helper(curr.next)) {
				return false;
			}
			if(curr.val!=front_pointer.val) {
				return false;
			}
			front_pointer=front_pointer.next;
		}
		return true;

	}
	//--------------------------
	//Not efficient O(n) space
	public static boolean palindrome(Node head) {
		List<Integer> list = new ArrayList<>();
		Node curr = head;
		while(curr!=null) {
			list.add(curr.val);
			curr=curr.next;
		}

		for(int i=0; i<list.size()/2; i++) {
			if(list.get(i)!=list.get(list.size() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}

class Node {
	int val;
	Node next;

	Node(int val) {
		this.val = val;
		this.next = null;
	}

	public void add(int val) {
		Node head = this;
		while(head.next!=null) {
			head=head.next;
		}
		head.next = new Node(val);
	}

	public void print() {
		Node curr = this;
		while(curr!=null) {
			System.out.print(curr.val+" -> ");
			curr=curr.next;
		}
		System.out.println();
	}
}