public class Traversal {
	public static void main(String args[]) {
		int[] inorder = {9,3,15,20,7};
		for(int i: inorder) {
			System.out.println(i);
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}