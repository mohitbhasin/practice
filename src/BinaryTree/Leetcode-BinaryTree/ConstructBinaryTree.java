import java.util.*;

class ConstructBinaryTree {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		List<Integer> pre = preorder(tree.getTree());
		List<Integer> in = inorder(tree.getTree());
		System.out.println(pre);
		System.out.println(in);
		TreeNode result = constructTree(0, 0, pre.size()-1, pre, in);
		System.out.println(preorder(result));
	}

	public static List<Integer> preorder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> result = new ArrayList<Integer>();

		stack.push(root);

		while(!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			result.add(curr.val);
			if(curr.right!=null) stack.push(curr.right);
			if(curr.left!=null) stack.push(curr.left);
		}

		return result;
	}

	public static List<Integer> inorder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
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

	public static TreeNode constructTree(int preStart, int inStart, int inEnd, List<Integer> preorder, List<Integer> inorder) {
		if(preStart>preorder.size()-1 || inStart>inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder.get(preStart));

		int inIndex = 0;
		for(int i=inStart; i<=inEnd; i++) {
			if(root.val==inorder.get(i)) {
				inIndex=i;
				break;
			}
		}

		root.left = constructTree(preStart + 1, inStart, inIndex - 1, preorder, inorder);
		root.right = constructTree(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);

		return root;
	}
}
