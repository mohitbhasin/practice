import java.util.*;

class FlattenBinaryTreeToLinkedList {
	public static void main(String args[]) {
		TreeNode t = new TreeNode();
		TreeNode root = t.getTree2();
		t.print(root);
		flat(root);
		t.print(root);

		
	}
	// Complexity O(n) runtime - each node processed once exactly once.
	// O(n) space - occupied by recursion stack
	public static TreeNode FindTailAndflatten(TreeNode root) {
		if(root==null) {
			return null;
		}
		if(root.left==null && root.right==null) {
			return root;
		}
		TreeNode left_tail = flat(root.left);
		TreeNode right_tail = flat(root.right);
		if(left_tail!=null) {
			left_tail.right = root.right;
			root.right = root.left;
			root.left=null;
		}
		//rightTail must be checked first than leftTail
		return right_tail==null ? left_tail : right_tail;
    }

    public static void flatten(TreeNode root) {
    	TreeNode curr = root;
    	Tree
    	while(curr!=null) {
    		if(curr.left!=null) {
    			curr
    		}
    	}
    }
}