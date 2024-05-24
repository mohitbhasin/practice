class SumRootToLeaf {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		System.out.println(sumRoot(tree.getTree2(), 0, 0));
	}

	public static int sumRoot(TreeNode root, int sum, int num) {
		if(root==null) {
			System.out.println("---> "+num);
			return sum+num;
		}
		int currNum = num*10+root.val;
		return sumRoot(root.left, sum, currNum) + sumRoot(root.right, sum, currNum);
	}
}