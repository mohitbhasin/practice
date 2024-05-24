import java.util.*;

class Inorder_iterative {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		// System.out.println(inOrder(tree.getTree()));
		System.out.println(inOrder2(tree.getTree()));
	}

	public static List<Integer> inOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> result = new ArrayList<>();
		TreeNode curr = root;
		while(!stack.isEmpty() || curr!=null) {
			if(curr!=null) {
				stack.push(curr);
				curr=curr.left;
			} else {
				curr = stack.pop();
				result.add(curr.val);
				curr = curr.right;
			}
		}
		return result;
	}


	public static List<Integer> inOrder2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr!=null) {
        	if(curr!=null) {
        		stack.push(curr);
        		curr=curr.left;
        	} else {
        		curr = stack.pop();
        		result.add(curr.val);
        		curr=curr.right;
        	}
        }
        return result;
	}
}