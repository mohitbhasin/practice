class IsUnivalue {
	static int count;
	public static void main(String args[]) {
		TreeNode root = new TreeNode();
		count=0;
		isUnival(root.getTreeUniVal());
		System.out.println(count);
	}

	public static boolean isUnival(TreeNode root) {
		if(root==null) {
			return true;
		}

		if(root.left==null && root.right==null) {
			count++;
			return true;
		}
		boolean isUnivalBool = true;

		if(root.left!=null) {
			isUnivalBool = isUnival(root.left) && isUnivalBool && root.left.val==root.val;
		}

		if(root.right!=null) {
			isUnivalBool = isUnival(root.right) && isUnivalBool && root.right.val==root.val;
		}

		if(isUnivalBool) {
			count++;
		}

		return true;
	}
}