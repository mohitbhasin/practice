class PathSum {
	public static void main(String args[]) {
		TreeNode t = new TreeNode();
		System.out.println(sumPath(t.getTree(), 48));
		System.out.println(sumPath2(t.getTree(), 47, 0));
		System.out.println(sumPath3(t.getTree(), 25, 0));
	}

	public static boolean sumPath(TreeNode root, int sum) {
		if(root==null && sum==0) {
			return true;
		}
		if(root==null && sum>0) {
			return false;
		}
		if(root!=null && sum==0) {
			return false;
		}
		if(root==null && sum<0) {
			return false;
		}
		sum-=root.val;
		return sumPath(root.left, sum) || sumPath(root.right, sum);
	}

	public static boolean sumPath2(TreeNode root, int sum, int curr) {
		if(root==null && curr!=sum) {
			return false;
		}
		if(root==null && sum==curr) {
			return true;
		}
		curr+=root.val;
		boolean left = sumPath2(root.left, sum, curr);
		boolean right = sumPath2(root.right, sum, curr);
		return left||right;
	}

	public static boolean sumPath3(TreeNode root, int target, int curr) {
		if(root==null) {
			return target==curr;
		}
		return sumPath3(root.left, target, curr+root.val) || sumPath3(root.right, target, curr+root.val);
	}
}