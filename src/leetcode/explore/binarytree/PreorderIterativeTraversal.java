package leetcode.explore.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderIterativeTraversal {
	
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
    	
    	Stack<TreeNode> s = new Stack<>();
    	
    	if(root!=null) {
    		s.push(root);
    	}
    	while(!s.isEmpty()) {
    		TreeNode temp = s.pop();
    		result.add(temp.val);
    		
    		if(temp.right!=null) {
    			s.push(temp.right);
    		}
    		
    		if(temp.left!=null) {
    			s.push(temp.left);
    		}
    	}
    	
    	
 		return result;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }	
}