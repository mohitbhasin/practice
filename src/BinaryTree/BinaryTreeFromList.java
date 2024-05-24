import java.util.*;

class BinaryTreeFromList {
	public static void main(String args[]) {
		TreeNode root = new TreeNode();
	 	// List<Integer> result = new ArrayList<Integer>();
	 	// preOrderTraversal(root.getTree(), result);
	  	// System.out.println(result);
	  	// TreeNode prime = generateTree(result);
	  	// List<Integer> result2 = new ArrayList<Integer>();
	  	// preOrderTraversal(prime, result2);
	  	// System.out.println(result2);
	  	List<Integer> result = levelOrderTraversal(root.getTree());
	  	System.out.println(result);
	}

	

	public static List<Integer> levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<Integer> result = new ArrayList<Integer>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			result.add(curr.val);
			if(curr.left!=null) queue.offer(curr.left);
			if(curr.right!=null) queue.offer(curr.right);
		}
		return result;
	}

	public static TreeNode generateTreeFromLevelOrder(List<Integer> nums, int index) {
		if(index<nums.size()) {
			
		}
		return null;
	}

	public static void preOrderTraversal(TreeNode root, List<Integer> result) {
		if(root==null) {
	    	result.add(null);
	    	return;
		  }
		  result.add(root.val);
		  preOrderTraversal(root.left, result);
		  preOrderTraversal(root.right, result); 
	}

	public static TreeNode generateTree(List<Integer> numbers) {
	  if(numbers.isEmpty() || numbers.get(0)==null) {
	    return null;
	  }

	  TreeNode root = new TreeNode(numbers.get(0));
	  root.left = generateTree(numbers.subList(1, numbers.size()));
	  root.right = generateTree(numbers.subList(1, numbers.size()));
	  return root;
	  
	}
}