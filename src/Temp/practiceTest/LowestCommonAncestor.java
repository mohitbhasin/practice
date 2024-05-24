class LowestCommonAncestor {
	public static void main(String args[]) {
		TreeNodeDefault tree = new TreeNodeDefault(1);

		System.out.println(ancestor(tree.getTree(), 5, 6));
	}

	public static TreeNodeDefault ancestor(TreeNodeDefault root, int p, int q) {
		if(root==null) {
			return null;
		}

		if(root.val == p || root.val == q) {
			return root;
		}

		TreeNodeDefault left = ancestor(root.left, p, q);
		TreeNodeDefault right = ancestor(root.right, p, q);
		if(left == null && right==null) {
			return null;
		}

		if(left!=null && right!=null) {
			return root;
		}

		return left!=null ? left : right;

	}
}