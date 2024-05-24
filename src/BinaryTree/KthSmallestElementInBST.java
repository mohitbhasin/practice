import java.util.*;

class KthSmallestElementInBST {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();

		System.out.println(kthSmallest(tree.bstNode(), 3));
	}

	public static int kthSmallest(TreeNode root, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        inorder(root, k, list);
        return list.getLast();
    }

    public static void inorder(TreeNode root, int k, LinkedList<Integer> list) {
        if(root!=null) {
            inorder(root.left, k, list);
            list.addLast(root.val);
            if(list.size()>k) list.removeLast();
            inorder(root.right, k, list);
        }
    }
}