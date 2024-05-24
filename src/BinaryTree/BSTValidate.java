class BSTValidate {
	public static void main(String args[]) {
		TreeNode root = new TreeNode();
		System.out.println(isValidBST(root.getBSTValid(),null, null));
	}

	//initially low and high cannot be used as Integer.MIN and MAX 
	// because a node can have MAX and MIN value
	// low and high used to for below scenario
	// 			5
	//		  /	   \ 
	// 		1		4
	//			  /	  \
	// 		--->3		6
	// without low/high the above case will return true, while this is not valid BST.
	 public static boolean isValidBST(TreeNode root, Integer low, Integer high) {
        if(root==null) {
            return true;
        }
        if((low!=null && root.val<=low) || (high!=null && root.val>=high)) {
        	return false;
        }
        
        boolean left = isValidBST(root.left, low, root.val);
        boolean right = isValidBST(root.right, root.val, high);
        
        return left && right;
    }
}