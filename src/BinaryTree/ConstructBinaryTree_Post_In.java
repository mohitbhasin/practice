import java.util.*;

class ConstructBinaryTree_Post_In {
	static Map<Integer, Integer> map;
	static int post_index;
	static int[] postorder;
	public static void main(String args[]) {
		int[] postorder = {9,15,7,20,3};
		int[] inorder = {9,3,15,20,7};
		
		TreeNode root = construct(inorder, postorder);
		root.print(root);

	}

	public static TreeNode construct(int[] in_order, int[] post_order) {
		map = new HashMap<>();
		postorder = post_order;
		post_index = postorder.length - 1;
		for(int i=0; i<in_order.length; i++) {
			map.put(in_order[i], i);
		}
		return helper(0, in_order.length-1);
	}



	public static TreeNode helper(int left, int right) {
		if(left>right) {
			return null;
		}

		TreeNode root = new TreeNode(postorder[post_index]);
		

		int in_index = map.get(root.val);
		post_index--;
		root.right = helper(in_index+1, right);
		root.left = helper(left, in_index-1);

		return root;
	}
}