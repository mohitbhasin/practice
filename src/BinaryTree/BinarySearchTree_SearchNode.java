class BinarySearchTree_SearchNode {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		TreeNode root = tree.bstNode();

		// TreeNode result = searchNode(root, 10);
		// System.out.println(result.val);

		TreeNode result = findAncestor(root, 4, 1);
		System.out.println(result.val);
	}

	public static TreeNode searchNode(TreeNode root, int p) {
		//if p value is present in the tree then null check not required.
		if(root==null) return null;
		if(p<root.val) {
			return searchNode(root.left, p);
		}
		if(p>root.val) {
			return searchNode(root.right, p);
		}
		return root;
	}

	public static TreeNode findAncestor(TreeNode root, int p, int q) {
		if(p<root.val && q<root.val) {
			return findAncestor(root.left, p, q);
		}
		if(p>root.val && q>root.val) {
			return findAncestor(root.right, p, q);
		}
		return root;
	}
}