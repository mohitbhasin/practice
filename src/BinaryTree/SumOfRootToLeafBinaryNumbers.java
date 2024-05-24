class SumOfRootToLeafBinaryNumbers {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		TreeNode root = tree.getBinaryNums();
		System.out.println(sumRootToLeaf(root));
	}

    static int sum;
	public static int sumRootToLeaf(TreeNode root) {
        if(root==null) return 0;
        sum = 0;
        preorder(root, 0);
        return sum;
    }
    public static void preorder(TreeNode root, int currNum) {
        if(root==null) return;
        currNum<<=1;
        currNum+=root.val;
        if(root.left==null && root.right==null) sum+=currNum;
        preorder(root.left, currNum);
        preorder(root.right, currNum);
    }
}