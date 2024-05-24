class BalancedTree {
	static int count;
	public static void main(String args[]) {
		TreeNode t = new TreeNode();
		count=0;
		System.out.println(isBalanced(t.getForBalanced()));
		System.out.println("count - "+count);
	}
	//O(N)
	public static boolean isBalanced(TreeNode root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}

	public static int checkHeight(TreeNode root) {
		if(root==null) {
			return -1;
		}

		int leftHeight = checkHeight(root.left);
		if(leftHeight==Integer.MIN_VALUE) return Integer.MIN_VALUE;
		int rightHeight = checkHeight(root.right);
		if(rightHeight==Integer.MIN_VALUE) return Integer.MIN_VALUE;

		int heightDiff = Math.abs(leftHeight - rightHeight);
		if(heightDiff > 1 ) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

// O(nlogn) not efficient - check craking the coding interview.
	public static boolean isBalanced2(TreeNode root) {
		if(root==null) {
			return true;
		}
		return Math.abs(height(root.left)-height(root.right))<2 && isBalanced(root.left) && isBalanced(root.right);
	}

	public static int height(TreeNode root) {
		if(root==null) {
			return -1;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}
}

	// 				1
	// 			2		2			false
	// 		3				3
	//	4						4


	// 				1
	// 			2		2			false
	// 		3		3
	// 	4		4