import java.util.*;

class Preorder {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		System.out.println(preorderTraversal(tree.getTree()));
	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		stack.push(root);

		while(!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			result.add(curr.val);
			if(curr.right!=null) {
				stack.push(curr.right);
			}
			if(curr.left!=null) {
				stack.push(curr.left);
			}
		}
		return result;
	}	
}