import java.util.*;

class ConstructBinaryTreeFromInAndPost {
	public static void main(String args[]) {
		int[] inOrder = {4,9,5,3,1,12};
		int[] postOrder = {9,4,3,12,1,5};

		TreeNode root = construct(inOrder, postOrder);
		root.print(root);
	}

	static int[] post_od;
	static int post_index;
	static Map<Integer, Integer> inorder_map;
	
	public static TreeNode construct(int[] inOrder, int[] postOrder) {
		// this.post_od = postOrder;
		// this.post_index = postOrder.length-1;
		// this.inorder_map = new HashMap<>();
		post_od = postOrder;
		post_index = postOrder.length-1;
		inorder_map = new HashMap<>();
		mapIndex(inOrder);
		return helper(0, postOrder.length-1);
	}

	public static TreeNode helper(int left, int right) {
		if(left>right) {
			return null;
		}

		TreeNode root = new TreeNode(post_od[post_index]);
		post_index--;
		int index = inorder_map.get(root.val);
		root.right = helper(index + 1, right);
		root.left = helper(left, index - 1);
		return root;
	}

	public static void mapIndex(int[] inOrder) {
		for(int i=0; i<inOrder.length; i++) {
			inorder_map.put(inOrder[i], i);
		}
	}
}