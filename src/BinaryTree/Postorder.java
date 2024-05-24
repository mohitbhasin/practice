import java.util.*;

class Postorder {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		// System.out.println (postOrder(tree.getTree()));
		System.out.println(postOderItr(tree.getTree()));
		System.out.println(postorderTraversal(tree.getTree()));
	}

	// Iterative - Easy to understand
	public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(0, curr.val);
            if(curr.left!=null) stack.push(curr.left);
            if(curr.right!=null) stack.push(curr.right);
        }
        return result;
    }

	public static List<Integer> postOderItr(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();

		List<Integer> result = new ArrayList<>();
		TreeNode curr = root;
		TreeNode pre = null;

		while(!stack.isEmpty() || curr!=null) {
			if(curr!=null) {
				stack.push(curr);
				curr=curr.left;
			} else {
				curr=stack.peek();
				if(curr.right==null || curr.right==pre) {
					result.add(curr.val);
					stack.pop();
					pre=curr;
					curr=null;
				} else {
					curr=curr.right;
				}
			}
		}
		return result;
	}

}