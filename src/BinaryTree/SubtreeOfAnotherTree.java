class SubtreeOfAnotherTree {
	public static void main(String args[]) {
		// TreeNode root = new TreeNode().getSubTree1();
		// TreeNode subRoot = new TreeNode().getSubTree2();

		TreeNode root = new TreeNode().getSubTree3();
		TreeNode subRoot = new TreeNode().getSubTree4();

		System.out.println(isSubtree(root, subRoot));

	}

	public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
       if(root==null) return false;
       boolean result = false;

       if(root.val==subRoot.val) {
       		count=1;
           if(compareTree(root, subRoot)) {
               return true;
           }
       }
       return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    static int count;
    public static boolean compareTree(TreeNode root, TreeNode subRoot) {
    	System.out.println("compareTree:"+count++);
        if(root==null && subRoot==null) return true;
        if((root==null && subRoot!=null) || (root!=null && subRoot==null)) return false;
        if(root.val!=subRoot.val) return false;
        // System.out.println(root.val+":"+subRoot.val);
        return compareTree(root.left, subRoot.left) && compareTree(root.right, subRoot.right);
    }
}