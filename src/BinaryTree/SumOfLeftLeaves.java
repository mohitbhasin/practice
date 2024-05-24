class SumOfLeftLeaves {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		TreeNode root = tree.getTree();
		System.out.println(sumOfLeftLeaves(root));
		System.out.println(sumOfLeftLeaves_alternate(root, false));
	}

	static int sum;
    public static int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        sum=0;
        preorder(root);
        return sum;
    }

    public static void preorder(TreeNode root) {
        if(root==null) return;
        if(root.left!=null) {
            if(root.left.left==null && root.left.right==null) {
                sum+=root.left.val;
            }
        }
        preorder(root.left);
        preorder(root.right);
    }

    public static int sumOfLeftLeaves_alternate(TreeNode root, boolean isLeft) {
    	if(root==null) return 0;
    	if(root.left==null && root.right==null) {
    		return isLeft ? root.val : 0;
    	}
    	int sum=0;
    	sum+=sumOfLeftLeaves_alternate(root.left, true);
    	sum+=sumOfLeftLeaves_alternate(root.right, false);
    	return sum;
    }
}