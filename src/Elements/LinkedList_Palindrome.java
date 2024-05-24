class LinkedList_Palindrome {
	public static void main(String args[]) {
		Node head = new Node(5);
		head.add(2);
		head.add(8);
		head.add(2);
		head.add(5);
		System.out.println(isPalindrome(head));
	}

	public static boolean isPalindrome(Node head) {
		Node fast=head;
		Node slow=head;

		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
		}

		slow=reverse(slow);
		fast=head;

		while(slow!=null) {
			System.out.println(fast.val+"---"+slow.val);
			if(fast.val != slow.val) {
				return false;
			}
			fast=fast.next;
			slow=slow.next;
		}
		return true;

	}

	public static Node reverse(Node head) {
		Node prev=null;
		while(head!=null) {
			Node next=head.next;
			head.next=prev;
			prev=head;
			head=next;
		}
		return prev;
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
}