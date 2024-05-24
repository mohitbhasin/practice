class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return val+" --> "+left+", "+right+"\n";
	}

	public TreeNode() {

	}
	public TreeNode getTree() {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(2);
		root.right = new TreeNode(31);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.left.right.left = new TreeNode(11);
		root.left.right.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		return root;
	}

	public TreeNode getTree2() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(6);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(11);
		return root;
	}
	public TreeNode getTree3() {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(1);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(5);
		root.right.right = new TreeNode(2);
		return root;
	}

	public TreeNode getTree4() {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(4);
		root.right = new TreeNode(16);
		root.left.left = new TreeNode(2);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(18);
		return root;
	}
}