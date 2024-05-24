class BSTInsert {
	public static void main(String args[]) {
		Node root = new Node(6);
		root.insert(root, 5);
		root.insert(root, 4);
		root.insert(root, 1);
		root.insert(root, 8);
		root.insert(root, 7);
		root.insert(root, 15);
		root.print();
	}
}

class Node {
	int val;
	Node left;
	Node right;
	Node(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

	public void print() {
		Node root = this;

		System.out.println(root.val);
		if(root.left!= null) root.left.print();
		if(root.right!= null) root.right.print();
	}

	public Node insert(Node root, int val) {
		if(root==null) {
			return new Node(val);
		}
		if(val<root.val) {
			root.left = insert(root.left, val);
		} else {
			root.right = insert(root.right, val);
		}
		return root;
	}
}