class MaximumPathSum {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		maxPathSum(tree.getTree());
		System.out.println(maxSum);
	}

	static int maxSum=Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        gainFromSubtree(root);
        return maxSum;
    }

    public static int gainFromSubtree(TreeNode root) {
        if(root==null) return 0;
        int left = Math.max(gainFromSubtree(root.left), 0);
        int right = Math.max(gainFromSubtree(root.right), 0);
        int sum = root.val + left + right;
        maxSum = Math.max(maxSum, sum);
        return root.val + Math.max(left, right);
    }
}