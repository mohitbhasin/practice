package leetcode.explore.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderIterativeTraversal {

	public static void main(String args[]) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2); 
        tree.right = new TreeNode(3); 
        tree.left.right = new TreeNode(4); 
        tree.left.left = new TreeNode(5); 
        tree.right.left = new TreeNode(6);
    	
    	System.out.println(postorderTraversal(tree));
		
	
	}
	
	public static List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
    	
    	Stack<TreeNode> s = new Stack<>();
    	if(root!=null) {
    		s.push(root);
    	}
    	
    	
    	while(!s.isEmpty()) {
    		TreeNode temp = s.peek();
    		if(temp.left==null && temp.right==null) {
    			result.add(s.pop().val);
    		}
    		else {
    			if(temp.right!=null) {
    				s.push(temp.right);
    				temp.right=null;
    			}
    			if(temp.left!=null) {
    				s.push(temp.left);
    				temp.left=null;
    			}
    		}
    	}
    	
    	
 		return result;
    }
}
