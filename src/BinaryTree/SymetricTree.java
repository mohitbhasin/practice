class SymetricTree {
	public static void main(String args[]) {
		TreeNode root = new TreeNode();
		TreeNode curr = root.getTree5();
		System.out.println(checkSym(curr, curr));
		System.out.println(checkSymmetric(curr));
	}

	public static boolean checkSymmetric(TreeNode root) {
        return isSymetric(root,root);
    }
    
    public static boolean isSymetric(TreeNode t1, TreeNode t2) {
        if(t1==null && t2==null) {
            return true;
        }
        if(t1==null || t2==null){
            return false;
        }
        return t1.val == t2.val && isSymetric(t1.left,t2.right) && isSymetric(t1.right,t2.left);
    }

	public static boolean checkSym(TreeNode r1, TreeNode r2) {
		if(r1 == null && r2 == null) {
			return true;
		}

		if(r1==null || r2==null || r1.val!=r2.val) {
			return false;
		}

		return checkSym(r1.left, r2.right) && checkSym(r1.right, r2.left);
	}
}