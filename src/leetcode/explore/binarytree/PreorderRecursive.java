package leetcode.explore.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PreorderRecursive {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2); 
        tree.right = new TreeNode(3); 
        tree.left.right = new TreeNode(4); 
        tree.left.left = new TreeNode(5); 
        tree.right.left = new TreeNode(6);
        
        List<Integer> result = new ArrayList<>();
        
        preOrder(tree,result);
        
        System.out.println(result);
	}
	
	public static void preOrder(TreeNode root, List<Integer> result) {
		if(root==null) {
			return;
		}
		result.add(root.val);
		if(root.left!=null) {
			preOrder(root.left, result);
		}
		if(root.right!=null) {
			preOrder(root.right, result);
		}
	}
}
