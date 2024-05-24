import java.util.*;
class ConstructBinayTree_Post_In {
	static int[] inorder = {9, 3, 15, 20, 7};
	static int[] postorder = {9, 15, 7, 20, 3};
	static int postIndex = postorder.length - 1;

	public static void main(String args[]) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<inorder.length; i++) {
			map.put(inorder[i], i);
		}
		TreeNode root = helper(0, inorder.length - 1, map);
		root.print(root);
	}

	public static TreeNode helper(int start, int end, Map<Integer, Integer> map) {
		if(start > end) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postIndex]);
		postIndex--;
		root.right = helper(map.get(root.val) + 1, end, map);
		root.left = helper(start, map.get(root.val) - 1, map);
		return root;
	}
}