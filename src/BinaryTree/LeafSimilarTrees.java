import java.util.*;

class LeafSimilarTrees {
	public static void main(String args[]) {
		int sum;
		sum+=1;
		System.out.println(sum);
		TreeNode root = new TreeNode();
		System.out.println(leafSimilar(root.getTree(), root.getTree()));
	}

	public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        preorder(root1, l1);
        List<Integer> l2 = new ArrayList<>();
        preorder(root2, l2);
        return l1.equals(l2);
    }
    
    public static void preorder(TreeNode root, List<Integer> list) {
        if(root==null) return;
        if(root.left==null && root.right==null) {
            list.add(root.val);
            return;
        }
        preorder(root.left, list);
        preorder(root.right, list);
    }
}