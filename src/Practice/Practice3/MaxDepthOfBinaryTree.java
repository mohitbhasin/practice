import java.util.*;
class MaxDepthOfBinaryTree {
	public static void main(String args[]) {
		TreeNodeDefault tree = new TreeNodeDefault(1).getTree();
		System.out.println(maxDepth(tree));
		System.out.println(inorderTraversal(tree));

	}

	public static int maxDepth(TreeNodeDefault root) {
		if(root==null) {
			return 0;
		}

		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	// not working. infintie loop
	public static List<Integer> inorderTraversal(TreeNodeDefault root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNodeDefault> stack = new Stack<TreeNodeDefault>();

		TreeNodeDefault curr;
		stack.push(root);
		while(!stack.isEmpty()) {
			curr=stack.peek();

			if(curr.left!=null) {
				stack.push(curr.left);

			} 
			else if(curr.left==null && curr.right==null) {
				result.add(curr.val);
				curr = stack.pop();
				result.add(curr.val);

			}
			else if(curr.right!=null)
			{
				stack.push(curr.right);
			}

		}
		System.out.println(stack);
		return result;
	}
}