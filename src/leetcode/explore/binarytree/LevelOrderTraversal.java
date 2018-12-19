package leetcode.explore.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2); 
        tree.right = new TreeNode(3); 
        tree.left.right = new TreeNode(4); 
        tree.left.left = new TreeNode(5); 
        tree.right.left = new TreeNode(6);
        
        List<List<Integer>> result = new ArrayList<>();
        
        result = levelOrder(tree);
        
        for(List l : result) {
            System.out.println(l);
        }
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		
		Queue<TreeNode> q = new LinkedList<>();
		if(root!=null) {
			q.offer(root);
		}
		
		TreeNode temp;
		
		while(!q.isEmpty()) {
			int size = q.size();
			List<Integer> l = new ArrayList<>();
			for(int i = 0; i<size;i++) {
				temp = q.poll();
				if(temp.left!=null) {
					q.offer(temp.left);
				}
				if(temp.right!=null) {
					q.offer(temp.right);
				}
				l.add(temp.val);
			}
			list.add(l);
		}
		
		return list;
		
	}
}
