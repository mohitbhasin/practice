class TreeDepth {
	public static void main(String args[]) {
		TreeNode root = new TreeNode().getMinDepth();
		// System.out.println(maxDepth_bottom_Up(root));
		// maximum_depth_TopToBottom(root, 1);
		// System.out.println(answer);
		System.out.println(minDepth(root));
	}

	//bottom up
	public static int maxDepth_bottom_Up(TreeNode root) {
		if(root==null) {
			return 0;
		}
		return 1 + (Math.max(maxDepth_bottom_Up(root.left), maxDepth_bottom_Up(root.right)));
	}

	// top to bottom - visit node and pass the value to children
	static int answer;
	private static void maximum_depth_TopToBottom(TreeNode root, int depth) {
	    if (root == null) {
	        return;
	    }
	    if (root.left == null && root.right == null) {
	        answer = Math.max(answer, depth);
	    }
	    maximum_depth_TopToBottom(root.left, depth + 1);
	    maximum_depth_TopToBottom(root.right, depth + 1);
	}

	//incorrect
	public static int minDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}

		if(root.left==null) return minDepth(root.right);
		if(root.right==null) return minDepth(root.left);
		return -1;

	}

}