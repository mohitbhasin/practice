import java.util.*;

class PreOrder {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		System.out.println(preorder(tree.getTree()));                

	}

	public static List<Integer> preorder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		stack.push(root);
		TreeNode curr;
		while(!stack.isEmpty()) {
			curr = stack.pop();
			result.add(curr.val);
			if(curr.right!=null) stack.push(curr.right);
			if(curr.left!=null) stack.push(curr.left);
		}
		return result;
	}	
}