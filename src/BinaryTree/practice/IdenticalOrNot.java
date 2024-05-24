class IdenticalOrNot {
	public static void main(String args[]) {
		TreeNode r1 = new TreeNode(2);
		TreeNode r2 = new TreeNode(2);

		System.out.println(compare(r1, r2));
	}

	public static boolean compare(TreeNode r1, TreeNode r2) {
		if(r1==null && r2==null) {
			return true;
		}
		if(r1.val!=r2.val) {
			return false;
		}

		return compare(r1.left, r2.left) && compare(r2.left, r2.left);
	}
}