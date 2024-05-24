import java.util.*;

class ReverseLinkedList {
	public static void main(String args[]) {
		List l = new List(1);
		for(int i=2; i<11; i++) {
			l.add(i);
		}
		// l.print();
		reverse(l).print();
		// l.print();
	}

	public static List reverse(List head) {
		List curr = head;
		List prev = null;
		while(curr!=null) {
			List temp = curr.next;
			curr.next = prev;
			prev=curr;			
			curr=temp;
		}

		return prev;
	}

}


class List {
	int val;
	List next;

	List(int val) {
		this.val = val;
		this.next = null;
	}

	public void add(int val) {
		List curr=this;
		while(curr.next!=null) {
			curr=curr.next;
		}
		curr.next = new List(val);
	}

	public void print() {
		List curr = this;
		while(curr!=null) {
			System.out.print(curr.val+" --> ");
			curr=curr.next;
		}
	}
}