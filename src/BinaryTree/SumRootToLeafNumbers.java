class SumRootToLeafNumbers {
	public static void main(String args[]) {
		TreeNode root = new TreeNode();

		System.out.println(sumNumbers(root.getTree()));
	}

	static int result=0;
    public static int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }
    
    public static void helper(TreeNode root, int curr) {
        if(root==null) {
            return;
        }
        curr*=10;
        curr+=root.val;
        if(root.left==null && root.right==null) {
            result+=curr;
        }
        helper(root.left, curr);
        helper(root.right, curr);
    }
}