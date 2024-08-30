class SumOfLeftLeaves {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		TreeNode root = tree.getTree();
		System.out.println(sumOfLeftLeaves(root));
		System.out.println(sumOfLeftLeaves_alternate(root));
        System.out.println(sumOfLeftLeaves_alternate2(root, false));
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

    public static int sumOfLeftLeaves_alternate(TreeNode root) {
        if(root==null) return 0;
        int left = sumOfLeftLeaves_alternate(root.left);
        int right = sumOfLeftLeaves_alternate(root.right);
        int sum = left + right;
        if(root.left!=null && root.left.left==null && root.left.right==null) sum+=root.left.val;
        return sum;
    }

    public static int sumOfLeftLeaves_alternate2(TreeNode root, boolean isLeft) {
    	if(root==null) return 0;
    	if(root.left==null && root.right==null) {
    		return isLeft ? root.val : 0;
    	}
    	int sum=0;
    	sum+=sumOfLeftLeaves_alternate2(root.left, true);
    	sum+=sumOfLeftLeaves_alternate2(root.right, false);
    	return sum;
    }
}