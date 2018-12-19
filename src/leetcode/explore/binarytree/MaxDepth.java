package leetcode.explore.binarytree;

public class MaxDepth {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2); 
        tree.right = new TreeNode(3); 
        tree.left.right = new TreeNode(4); 
        tree.left.left = new TreeNode(5); 
        tree.right.left = new TreeNode(6);
        
        System.out.println(maxDepth(tree));
	}
	
	public static int maxDepth(TreeNode root) {
		int depth=0;
		int left;
		int right;
		if(root!=null) {
			left=maxDepth(root.left);
			right=maxDepth(root.right);
			depth = Math.max(left, right);
			return depth + 1;
		}
		else {
			return 0;
		}
	}
}
