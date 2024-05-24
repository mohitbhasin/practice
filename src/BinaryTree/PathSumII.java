import java.util.*;

class PathSumII {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		TreeNode root = tree.pathSumII();
		System.out.println(pathSum(root, 22));
	}

	public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        helper(root, new ArrayList<Integer>(), 0, targetSum, result);
        return result;
    }
    
    public static void helper(TreeNode root, List<Integer> path, int sum, int targetSum, List<List<Integer>> result) {
    	if(root==null) return; 
        path.add(root.val);
        sum+=root.val;
        if(sum==targetSum && root.right==null && root.right==null) {
            result.add(new ArrayList<>(path));
        }
        helper(root.left, path, sum, targetSum, result);
        helper(root.right, path, sum, targetSum, result);
        path.remove(path.size()-1);
    }
}