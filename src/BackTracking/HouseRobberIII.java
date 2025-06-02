class HouseRobberIII {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		TreeNode root = tree.houseRobberIII();
		
		System.out.println(rob(root));
	}

	public static int rob(TreeNode root) {
		int[] result = helper(root);
		return Math.max(result[0], result[1]);
	}

	public static int[] helper(TreeNode root) {
		if(root==null) return new int[]{0,0};
    	int[] left = helper(root.left);
    	int[] right = helper(root.right);
    	int[] sum = new int[2];
    	sum[0] = root.val + left[1]+right[1];
    	sum[1] = Math.max(left[0], left[1])+Math.max(right[0], right[1]);
    	return sum;
	}
}

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;

	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

	public TreeNode() {

	}

	public TreeNode houseRobberIII() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(25);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(12);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(1);
		return root;
	}
}