import java.util.List;
import java.util.ArrayList;

class Practice10 {
	public static void main(String args[]) {
		System.out.println(preorderTraversal(new TreeNode(2)));
	}

	public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preOrder(root, result);
        return result;
    }
    public static List<Integer> preOrder(TreeNode root, List<Integer> result) {
		if(root==null) return result;
		result.add(root.val);
		preOrder(root.left, result);
		preOrder(root.right, result);
		return result;
	}

	public static List<Integer> preorderItr(TreeNode root) {
		if(root==null) return new ArrayList();
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<Integer>();
		stack.push(root);
		TreeNode temp;
		while(!stack.isEmpty()) {
			temp=stack.pop();
			result.add(temp.val);
			if(temp.right!=null) stack.push(temp.right);
			if(temp.left!=null) stack.push(temp.left);
		}
		return result;
	}

	public static List<Integer> inOrderItr(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root==null) return result;
		
		
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }	
	}
}