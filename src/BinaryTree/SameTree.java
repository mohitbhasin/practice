class SameTree {
	public static void main(String args[]) {
		TreeNode t = new TreeNode();
		System.out.println(isSameTree(t.getTree(), t.getTree()));
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null && q==null) {
		    return true;
		}
		if((p==null && q!=null) || (p!=null && q==null) || p.val!=q.val) {
		    return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);        
	}
}