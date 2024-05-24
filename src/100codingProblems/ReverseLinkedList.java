class ReverseLinkedList {
	public static void main(String args[]) {
		Node list = new Node(1);
		int i=2;
		while(i++<11) {
			list.add(i);
		}

		list.print();
	}
}

class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}

		public void add(int data) {
			Node temp = this;
			while(temp!=null) {
				temp=temp.next;
			}

			temp=new Node(data);
			temp.next = null;
		}

		public void print() {
			Node temp = this;
			while(temp!=null) {
				System.out.println(temp.data);
				temp=temp.next;
			}
		}
	}