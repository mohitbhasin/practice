import java.util.*;

class ConstructBinaryTree {
	public static void main(String args[]) {
		// in_order(tree.getTree());
		// System.out.println();
		// pre_order(tree.getTree());
		int[] inorder = {4, 2, 11, 8, 5, 10, 6, 31, 7};
		int[] preorder = {10, 2, 4, 8, 11, 5, 31, 6, 7};
		TreeNode curr = new TreeNode(preorder[0]);
		Stack<TreeNode> stack = new Stack<>();
		construct3(stack, inorder, preorder, 0, 0, curr);
		pre_order(curr);

	}

	public static TreeNode construct3(Stack<TreeNode> stack, int[] inorder, int[] preorder, int in_Index, int pre_Index, TreeNode curr) {
		if(in_Index>=inorder.length || pre_Index>=preorder.length) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[pre_Index]);
		stack.push(root);
			
		root.left = construct3(stack, inorder, preorder, in_Index, pre_Index+1, root.left);
		if(preorder[pre_Index]==inorder[in_Index]) {
			root.right=construct3(stack, preorder, inorder, in_Index+1, pre_Index, stack.pop());
		}
		return root;
	}

	public static TreeNode constructRecur(int[] inorder, int[] preorder, int in_Index, int pre_Index) {
		if(pre_Index>=preorder.length) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[pre_Index]);
		if(preorder[pre_Index+1]==inorder[in_Index]) {
			root.right = constructRecur(inorder, preorder, in_Index+1, pre_Index+1);
		} else {
			root.left = constructRecur(inorder, preorder, in_Index, pre_Index+1);
		}

		return root;
	}

	public static TreeNode construct(int[] inorder, int[] preorder) {

		Stack<TreeNode> stack = new Stack<>();
		int in_Index=0;
		int pre_Index=0;
		TreeNode root = new TreeNode(preorder[pre_Index++]);
		TreeNode curr=root;
		stack.push(curr);


		while(pre_Index<preorder.length) {
			if(stack.peek().val==inorder[in_Index]) {
				in_Index++;
				curr=stack.pop();
			}
			if(preorder[pre_Index]!=inorder[in_Index]) {
				stack.push(curr);
				curr.left=new TreeNode(preorder[pre_Index++]);
				curr=curr.left;
			} else {
				in_Index++;
				curr=stack.pop();
				curr.right=new TreeNode(preorder[pre_Index++]);
				curr=curr.right;
			}
			// System.out.println(stack.peek().val);
		}
		return root;
	}

	public static void in_order(TreeNode root) {
		if(root==null) {
			return;
		}
		in_order(root.left);
		System.out.print(root.val+", ");
		in_order(root.right);
	}
	public static void pre_order(TreeNode root) {
		if(root==null) {
			return;
		}
		System.out.print(root.val+", ");
		pre_order(root.left);
		pre_order(root.right);
	}
}