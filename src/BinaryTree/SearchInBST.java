class SearchInBST {
	public static void main(String args[]) {
		TreeNode root = new TreeNode();
		System.out.println(search(root.getTree4(), 7));
	}

	public static TreeNode search(TreeNode root, int val) {
		if(root==null) {
			return null;
		}
		if(root.val==val) {
			return root;
		}
		return val > root.val ? search(root.right, val) : search(root.left, val);
	}
}