class MinDepth {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		System.out.println(minDepth(tree.getMinDepth()));
	}

	public static int minDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null) {
			return minDepth(root.right)+1;
		}
		if(root.right==null) {
			return minDepth(root.left)+1;
		}

		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}
}