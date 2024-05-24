class MaxDepth {
	public static void main(String args[]) {
		TreeNode root = new TreeNode().getMinDepth();
		System.out.println(depthRec(root));
	}

	public static int depthRec(TreeNode root) {
		if(root==null) {
			return 0;
		}

		return 1+Math.max(depthRec(root.left), depthRec(root.right));
	}
}