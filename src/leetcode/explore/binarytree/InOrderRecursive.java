package leetcode.explore.binarytree;

import java.util.ArrayList;
import java.util.List;

public class InOrderRecursive {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2); 
        tree.right = new TreeNode(3); 
        tree.left.right = new TreeNode(4); 
        tree.left.left = new TreeNode(5); 
        tree.right.left = new TreeNode(6);
        
        List<Integer> result = new ArrayList<>();
        
        inOrder(tree,result);
        
        System.out.println(result);
	}
	
	public static void inOrder(TreeNode root, List<Integer> result) {
		if(root==null) {
			return;
		}
		if(root.left!=null) {
			inOrder(root.left, result);
		}
		result.add(root.val);
		if(root.right!=null) {
			inOrder(root.right, result);
		}
	}
}
