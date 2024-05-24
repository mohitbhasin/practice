class MaxHeight {
	public static void main(String args[]) {
		Node root = new Node(6);
		root.insert(root, 5);
		root.insert(root, 4);
		root.insert(root, 1);
		root.insert(root, 8);
		root.insert(root, 7);
		root.insert(root, 15);
		System.out.println(maxHeight(root));
	}

	public static int maxHeight(Node root) {
		if(root == null) {
			 return 0;
		}

		int left = maxHeight(root.left);
		int right = maxHeight(root.right);

		return Math.max(left, right) + 1;
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