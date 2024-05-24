import java.util.*;

class SmallestSubtreeWithAllDeepestNodes {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		TreeNode root = tree.getTree();
		// for(TreeNode node: map.keySet()) {
		// 	System.out.println(node.val + ": "+map.get(node));
		// }

		TreeNode result = subtreeWithAllDeepest(root);
		System.out.println(result.val);
	}

	static Map<TreeNode, Integer> map;
    static int maxDepth;
    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        map = new HashMap<>();
        markDepth(root,0);
        return ancestor(root);   
    }

    public static void markDepth(TreeNode root, int depth) {
        if(root!=null) {
            map.put(root, depth);

            maxDepth=Math.max(maxDepth, depth);
            markDepth(root.left, depth+1);
            markDepth(root.right, depth+1);
        }
    }

    public static TreeNode ancestor(TreeNode root) {
        if(root==null || map.get(root)==maxDepth) {
            return root;
        }
        TreeNode left = ancestor(root.left);
        TreeNode right = ancestor(root.right);
        if(left!=null && right!=null) {
            return root;
        }
        if(left!=null) return left;
        else return right;
    }
}