import java.util.*;

class ClosestBinarySearchTreeValue {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		System.out.println(closestValue(tree.bstNode(), 1.2321));
		System.out.println(closestValue(tree.bstNode(), 1));
	}

	public static int closestValue(TreeNode root, double target) {
        absMinDiff = Integer.MAX_VALUE;
        result = 0;
        dfs(root, target);
        return result;
    }
    
    static double absMinDiff;
    static int result;
    
    public static void dfs(TreeNode root, double target) {
        if(root==null) return;
        if(target == (double) root.val) {
            result = root.val;
            return;
        }
        double currDiff = Math.abs(root.val-target);
        if(currDiff<absMinDiff || (currDiff==absMinDiff && root.val<result)) {
            result = root.val;
            absMinDiff = currDiff;
        }
        if(target>root.val) {
            dfs(root.right, target);
        } else {
            dfs(root.left, target);
        }
    }
}