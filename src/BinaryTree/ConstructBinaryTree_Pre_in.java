import java.util.*;

class ConstructBinaryTree_Pre_in {
	static Map<Integer, Integer> map;
	static int pre_index;
	static int[] preorder;
	public static void main(String args[]) {
		int[] preorder = {9,15,7,20,3};
		int[] inorder =  {9,3,15,20,7};
		
		TreeNode root = construct(inorder, preorder);
		root.print(root);

	}

	public static TreeNode construct(int[] in_order, int[] pre_order) {
		map = new HashMap<>();
		preorder = pre_order;
		pre_index = 0;
		for(int i=0; i<in_order.length; i++) {
			map.put(in_order[i], i);
		}
		return helper(0, in_order.length-1);
	}



	public static TreeNode helper(int left, int right) {
		if(left>right) {
			return null;
		}

		int rootValue = preorder[pre_index++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left =  helper(left, map.get(rootValue) - 1);
        root.right = helper(map.get(rootValue) + 1, right);
        return root;

		// TreeNode root = new TreeNode(preorder[pre_index]);
		

		// int in_index = map.get(root.val);
		// pre_index++;
		// root.left = helper(left, in_index-1);
		// root.right = helper(in_index+1, right);

		// return root;
	}
}