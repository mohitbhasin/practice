import java.util.*;

class FindLeavesOfBianryTree {
	static List<List<Integer>> result;

	public static void main(String args[]) {
		TreeNode root = new TreeNode();
		findLeaves(root.getTree());
	}

	public static List<List<Integer>> findLeaves(TreeNode root) {
		result = new ArrayList<>();
		countHeight(root);
		System.out.println(result);
		return result;
	}

	public static int countHeight(TreeNode root) {
		if(root==null) {
			return -1;
		}

		int left = countHeight(root.left);
		int right = countHeight(root.right);

		int maxHeight = Math.max(left, right) + 1;

		if(maxHeight==result.size()) {
			result.add(new ArrayList<Integer>());
		}
		result.get(maxHeight).add(root.val);

		return maxHeight;
	}
}