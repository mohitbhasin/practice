import java.util.*;

class MergeTrees {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		TreeNode r1 = tree.getTree2();
		TreeNode r2 = tree.getTree3();
		merge(r1, r2);
		levelOrderTraversal(r1);
	}

	public static void levelOrderTraversal(TreeNode root) {
		List<List<TreeNode>> result = new ArrayList<>();
		List<TreeNode> level;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int size = 0;
		while(!queue.isEmpty()) {
			level = new ArrayList<>();
			size = queue.size();
			for(int i=0; i<size; i++) {
				TreeNode curr = queue.poll();
				level.add(curr);
				if(curr.left!=null) queue.offer(curr.left);
				if(curr.right!=null) queue.offer(curr.right);
			}
			result.add(level);
		}
		for(List<TreeNode> l: result) {
			System.out.println(l);	
		}
	}

	public static TreeNode merge(TreeNode root1, TreeNode root2) {
		if(root1==null && root2!=null) {
			return new TreeNode(root2.val);
		}
		else if(root1==null && root2==null) {
			return null;
		}
		else if(root1!=null && root2==null) {
			return root1;
		}
		else {
			root1.val+=root2.val;
		}
		root1.left = merge(root1.left, root2.left);
		root1.right = merge(root1.right, root2.right);

		return root1;
	}
}