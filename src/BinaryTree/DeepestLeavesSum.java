class DeepestLeavesSum {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		TreeNode root = tree.getTree();
		System.out.println(deepestLeavesSum(root));
	}

	public static int deepestLeavesSum(TreeNode root) {
        if(root==null) return 0;
        depth=0;
        sum=0;
        preorder(root, 0);
        return sum;
    }

    static int depth;
    static int sum;

    public static void preorder(TreeNode root, int currDepth) {
        if(root==null) return;
        if(root.left==null && root.right==null) {
            if(currDepth>depth) {
                depth=currDepth;
                sum=root.val;
            } else if(currDepth==depth) {
                sum+=root.val;
            }
        }
        preorder(root.left, currDepth+1);
        preorder(root.right, currDepth+1);
    }
}