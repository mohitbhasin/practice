import java.util.*;

class BinayTreePaths {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		TreeNode root = tree.getTree();

        System.out.println(binaryTreePaths_better(root));
		System.out.println(binaryTreePaths(root));
	}

    public static List<String> binaryTreePaths_better(TreeNode root) {
        List<String> result = new ArrayList<>();
        helper(root, result, "");
        return result;
    }
    
    public static void helper(TreeNode root, List<String> result, String path) {
        if(root==null) return;
        if(root.left==null && root.right==null) {
            path+=root.val;
            result.add(path);
            return;
        }
        path+=root.val+"->";
        helper(root.left, result, path);
        helper(root.right, result, path);
    }

	static List<String> paths;
    public static List<String> binaryTreePaths(TreeNode root) {
        paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, path);
        return paths;
    }

    public static void helper(TreeNode root, List<Integer> path) {
        if(root==null) {
            return;
        }
        // preorder
        path.add(root.val);
        helper(root.left, path);
        helper(root.right, path);
        // postOrder
        if(root.left==null && root.right==null) {
            String pString="";
            for(int p: path) {
                pString+=p + "->";                
            }
            pString=pString.substring(0, pString.length()-2);
            paths.add(pString);
        }
        // backtrack
        path.remove(path.size()-1);
    }
}