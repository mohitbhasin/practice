class PathSum {
	public static void main(String args[]) {
		TreeNodeDefault tree = new TreeNodeDefault(1);
		System.out.println(isSum(tree.getTree(), 42));

	}

	public static boolean isSum(TreeNodeDefault root, int targetSum) {
		return helper(root, targetSum, 0);
	}

	public static boolean helper(TreeNodeDefault root, int targetSum, int currSum) {
		if(root==null && currSum==targetSum) {
			return true;
		}
		if(currSum>targetSum || root==null) {
			return false;
		}
		System.out.println(root.val);
		currSum+=root.val;
		return helper(root.left, targetSum, currSum) || helper(root.right, targetSum, currSum);
	} 
}