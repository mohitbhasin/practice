package leetcode.explore.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PostOrderRecursive {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2); 
        tree.right = new TreeNode(3); 
        tree.left.right = new TreeNode(4); 
        tree.left.left = new TreeNode(5); 
        tree.right.left = new TreeNode(6);
        
        List<Integer> result = new ArrayList<>();
        
        postOrder(tree,result);
        
        System.out.println(result);
	}
	
	
	public static void postOrder(TreeNode root, List<Integer> result) {
		if(root==null) {
			return;
		}
		if(root.left!=null) {
			postOrder(root.left, result);
		}
		if(root.right!=null) {
			postOrder(root.right, result);
		}
		result.add(root.val);
	}
}
