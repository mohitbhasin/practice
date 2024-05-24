import java.util.*;

class SymmetricTree {
	public static void main(String args[]) {
		TreeNode root = new TreeNode();
		TreeNode curr = root.getSymetricTree();
		System.out.println(isSymmetric(curr));
		System.out.println(isSymmetric_iterative(curr));
	}

	 public static boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return preorder(root.left, root.right);
    }
    
    public static boolean preorder(TreeNode a, TreeNode b) {
        if(a==null && b==null) return true;
        if(a==null || b==null) return false;
        if(a.val!=b.val) return false;
        return preorder(a.left, b.right) && preorder(a.right, b.left);
    }

	public static boolean isSymmetric_iterative(TreeNode root) {
		Queue<TreeNode> que = new LinkedList<>();
	    que.offer(root);
	    que.offer(root);
	    while(!que.isEmpty()) {
	            TreeNode a = que.poll();
	            TreeNode b = que.poll();
	            if(a==null && b==null) continue;
	            if(a==null || b==null || a.val!=b.val) return false;
	            que.offer(a.left);
	            que.offer(b.right);
	            que.offer(a.right);
	            que.offer(b.left);
	    }
	    return true;
	}
}