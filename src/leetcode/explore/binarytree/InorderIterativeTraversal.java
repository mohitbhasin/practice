package leetcode.explore.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderIterativeTraversal {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode(1);
		 tree.left = new TreeNode(2); 
	        tree.right = new TreeNode(3); 
	        tree.left.right = new TreeNode(4); 
	        tree.left.left = new TreeNode(5); 
	        tree.right.left = new TreeNode(6);
	        
	        Solution2 s = new Solution2();
	    	
	    	
	    	
	    	System.out.println(s.inorderTraversal(tree));
	
	}
	
	
	
}

class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
    	
    	Stack<TreeNode> s = new Stack<>();
    	
    	TreeNode temp = root;
    	while(temp!=null || s.size()>0) {
    		while(temp!=null) {
        		s.push(temp);
        		temp=temp.left;
        	}
    		temp = s.pop();
        	result.add(temp.val);
        	
        	temp = temp.right;
    	}
 		return result;
    }
}

